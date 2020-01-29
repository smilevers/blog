package com.smile.controller.admin;

import com.github.pagehelper.PageInfo;
import com.smile.po.Tag;
import com.smile.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @Author: smile
 * @Date: 2020/1/24
 */
@Controller
@RequestMapping("admin")
public class TagsController {
    
    @Autowired
    private TagService tagService;
    
    /**
     * 分页查询所有tags
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @GetMapping("tags")
    public String listTags(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize, Model model) {
        List<Tag> tags = tagService.listTag(pageNum, pageSize);
        PageInfo<Tag> pageInfo = new PageInfo<>(tags);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/tags";
    }
    
    /**
     * 新增静态页面跳转
     * @return
     */
    @GetMapping("tags/inputs")
    public String typesInput(Model model) {
        model.addAttribute("tag", new Tag());
        return "admin/tags-input";
    }
    
    /**
     * 新增标签
     * @param tag
     * @param redirectAttributes
     * @return
     */
    @PostMapping("tags")
    public String insertTag(Tag tag, RedirectAttributes redirectAttributes) {
        Tag backTag = tagService.getTag(tag.getId());
        // id的值不为空就更新对象，否则就新增对象
        if (tag.getId() != null) {
            if (tagService.updateTag(tag) == 1) {
                redirectAttributes.addFlashAttribute("message", "操作成功");
                return "redirect:/admin/tags";
            } else {
                redirectAttributes.addFlashAttribute("message", "操作失败");
                return "redirect:/admin/tags";
            }
    
        }else {
            if (backTag != null) {
                redirectAttributes.addFlashAttribute("message", "不能添加重复的标签");
                return "redirect:/admin/tags/inputs";
            } else {
                tagService.insertTag(tag);
                redirectAttributes.addFlashAttribute("message", "操作成功");
                return "redirect:/admin/tags";
            }
        }
    
        
    }
    
    /**
     * 更新跳转页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("tags/{id}/input")
    public String updateTag(@PathVariable Long id, Model model) {
        model.addAttribute("tag", tagService.getTag(id));
        return "admin/tags-input";
    }
    
    /**
     * 删除tag
     * @param id
     * @param redirectAttributes
     * @return
     */
    @GetMapping("tags/{id}/delete")
    public String deleteTag(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (tagService.deleteTag(id) == 1) {
            redirectAttributes.addFlashAttribute("message", "操作成功");
            return "redirect:/admin/tags";
        } else {
            redirectAttributes.addFlashAttribute("message", "操作失败");
            return "redirect:/admin/tags";
        }
    }
}
