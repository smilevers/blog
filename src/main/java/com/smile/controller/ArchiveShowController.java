package com.smile.controller;

import com.smile.po.Blog;
import com.smile.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

/**
 * 前端归档视图管理
 * @Author: smile
 * @Date: 2020/1/27
 */
@Controller
public class ArchiveShowController {
    
    @Autowired
    private BlogService blogService;
    
    /**
     * 归档展示
     * @param model
     * @return
     */
    @GetMapping("archive")
    public String archive(Model model) {
        Map<String, List<Blog>> archive = blogService.archive();
        model.addAttribute("map", archive);
        model.addAttribute("count", blogService.allBlogCouint());
        return "archives";
    }
}
