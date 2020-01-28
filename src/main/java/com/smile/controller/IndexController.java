package com.smile.controller;

import com.github.pagehelper.PageInfo;
import com.smile.exception.NotFoundException;
import com.smile.po.Blog;
import com.smile.po.Tag;
import com.smile.po.Type;
import com.smile.po.User;
import com.smile.service.BlogService;
import com.smile.service.TagService;
import com.smile.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前端首页视图管理
 * @Author: smile
 * @Date: 2020/1/20
 */
@Controller
public class IndexController {
    
    @Autowired
    private BlogService blogService;
    
    @Autowired
    private TypeService typeService;
    
    @Autowired
    private TagService tagService;
    
    
    
    /**
     * blog首页展示
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @GetMapping("/")
    public String indexShow(@RequestParam(defaultValue = "1") Integer pageNum
                          , @RequestParam(defaultValue = "6") Integer pageSize , Model model) {
        // 获取blogs分页列表,并返回页面
        List<Blog> blogs = blogService.listAllBlog(pageNum, pageSize);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo", pageInfo);
        // 获取type排序列表，并返回页面
        List<Type> types = typeService.listSortType(1,6);
        model.addAttribute("types", types);
        // 获取tags排序列表，并返回页面
        List<Tag> tags = tagService.listSortTag(1, 10);
        model.addAttribute("tags", tags);
        // 获取最新推荐blog列表，并返回页面
        List<Blog> blogList = blogService.listNewBlog();
        model.addAttribute("blogList", blogList);
        return "index";
    }
    
    /**
     * blog详情展示
     * @return
     */
    @GetMapping("blog/{id}")
    public String blog(@PathVariable Long id,Model model) {
        Blog blog = blogService.getBlogAndConvert(id);
        model.addAttribute("blog", blog);
        return "blog";
    }
    
    /**
     * 搜索展示
     * @return
     */
    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "1") Integer pageNum
            , @RequestParam(defaultValue = "5") Integer pageSize , Model model,@RequestParam(name = "query") String query) {
        System.out.println(query);
        
        List<Blog> blogs = blogService.searchBlogs(pageNum,pageSize,query);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("query", query);
        
        return "search";
    }
}
