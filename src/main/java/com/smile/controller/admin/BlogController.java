package com.smile.controller.admin;

import com.github.pagehelper.PageInfo;
import com.smile.po.Blog;
import com.smile.po.Tag;
import com.smile.po.Type;
import com.smile.po.User;
import com.smile.service.BlogService;
import com.smile.service.TagService;
import com.smile.service.TypeService;
import com.smile.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 博客管理
 * @Author: smile
 * @Date: 2020/1/20
 */
@Controller
@RequestMapping("admin")
public class BlogController {
    
    private static final String INPUT = "/admin/blogs-input";
    private static final String LIST = "/admin/blogs";
    private static final String REDIRECT_LIST = "redirect:/admin/blogs";
    
    @Autowired
    BlogService blogService;
    
    @Autowired
    TypeService typeService;
    
    @Autowired
    TagService tagService;
    
    /**
     * 分页动态模糊查询
     * @param blog
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @GetMapping("blogs")
    public String listBlogs(BlogQuery blog, @RequestParam(defaultValue = "1") Integer pageNum
                                          , @RequestParam(defaultValue = "10") Integer pageSize , Model model,HttpSession session) {
       
        List<Blog> blogs = blogService.listBlogs(blog, pageNum, pageSize);
        for (Blog setblog: blogs) {
            setblog.setUser((User) session.getAttribute("user"));
        }
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo", pageInfo);
        // 初始化分类
        model.addAttribute("types", typeService.listTypes());
        return LIST;
    }
    
    /**
     * 分页动态模糊查询片段
     * @param blog
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @PostMapping("blogs/search")
    public String search(BlogQuery blog, @RequestParam(defaultValue = "1") Integer pageNum
            , @RequestParam(defaultValue = "10") Integer pageSize , Model model) {
        
        List<Blog> blogs = blogService.listBlogs(blog, pageNum, pageSize);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo", pageInfo);
        return "/admin/blogs :: blogList";
    }
    
    /**
     * 响应全部分类跳转到新增页面
     * @param model
     * @return
     */
    @GetMapping("blogs/inputs")
    public String input(Model model) {
        model.addAttribute("blog", new Blog());
        // 初始化types
        model.addAttribute("types", typeService.listTypes());
        // 初始化tags
        model.addAttribute("tags", tagService.listTags());
        return INPUT;
    }
    
    /**
     * 新增blog
     * @param blog
     * @param redirectAttributes
     * @param session
     * @return
     */
    @PostMapping("blogs")
    public String insert(Blog blog,RedirectAttributes redirectAttributes, HttpSession session) {
        System.out.println(blog);
        // 从session中获取user对象初始化blog中userId
        blog.setUserId(((User) session.getAttribute("user")).getId());
        // 如果id为空，说明是新增对象,否则及更新对象
        if (blog.getId() == null) {
            if (blogService.insertBlog(blog) == 1) {
                blogService.insertBlogAndTag(blog);
                redirectAttributes.addFlashAttribute("message", "操作成功");
            } else {
                redirectAttributes.addFlashAttribute("message", "操作失败");
            }
        } else {
            if (blogService.updateBlog(blog) == 1) {
                blogService.insertBlogAndTag(blog);
                redirectAttributes.addFlashAttribute("message", "操作成功");
            } else {
                redirectAttributes.addFlashAttribute("message", "操作失败");
            }
        }
        return REDIRECT_LIST;
    }
    
    /**
     * 更新blog跳转页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("blogs/{id}/input")
    public String updateBlog( @PathVariable Long id,  Model model ) {
        System.out.println(id);
    
        // 初始化types
        model.addAttribute("types", typeService.listTypes());
        // 初始化tags
        List<Tag> tags = tagService.listTags();
        
        
        model.addAttribute("tags", tags);
        // 返回更改blog
        model.addAttribute("blog", blogService.getBlog(id));
        return INPUT;
    }
    
    /**
     * 删除分类
     * @param id
     * @param redirectAttributes
     * @param model
     * @return
     */
    @GetMapping("blogs/{id}/delete")
    public String deleteBlog(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model ) {
    
        if (blogService.deleteBlog(id) == 1) {
            redirectAttributes.addFlashAttribute("message", "操作成功");
        } else {
            redirectAttributes.addFlashAttribute("message", "操作失败");
        }
    
        return REDIRECT_LIST;
    }
}
