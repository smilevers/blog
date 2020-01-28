package com.smile.controller;

import com.github.pagehelper.PageInfo;
import com.smile.po.Blog;
import com.smile.po.Tag;
import com.smile.service.BlogService;
import com.smile.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 前端标签视图管理
 * @Author: smile
 * @Date: 2020/1/27
 */
@Controller
public class TagShowController {
    
    @Autowired
    private TagService tagService;
    
    @Autowired
    private BlogService blogService;
    
    @GetMapping("tags")
    public String listTags(Long id, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "8") Integer pageSize, Model model) {
        List<Tag> tags = tagService.listSortTag(1, 200);
        if (id != null && id == -1) {
            id = tags.get(0).getId();
        }
        List<Blog> blogs = blogService.listTagBlogCount(id, pageNum, pageSize);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("tags", tags);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("activeTypeId", id);
        return "tags";
    }
}
