package com.smile.controller;

import com.github.pagehelper.PageInfo;
import com.smile.po.Blog;
import com.smile.po.Type;
import com.smile.service.BlogService;
import com.smile.service.TypeService;
import com.smile.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 前端分类展示
 * @Author: smile
 * @Date: 2020/1/27
 */
@Controller
public class TypeShowController {
    
    @Autowired
    private TypeService typeService;
    
    @Autowired
    private BlogService blogService;
    
    /**
     * 分类展示
     * @param id
     * @param model
     * @return
     */
    @GetMapping("types")
    public String listTypes(Long id, @RequestParam(defaultValue = "1" ,name = "pageNum") Integer pageNum, @RequestParam(defaultValue = "8") Integer pageSize ,Model model) {
        List<Type> types = typeService.listSortType(1, 100);
        if (id !=null && id == -1) {
            id = types.get(0).getId();
        }
        BlogQuery query = new BlogQuery();
        query.setTypeId(id);
        model.addAttribute("types", types);
        List<Blog> blogList = blogService.listBlogs(query, pageNum, pageSize);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        model.addAttribute("pageInfo",pageInfo );
        model.addAttribute("activeTypeId", id);
        return "types";
    }
}
