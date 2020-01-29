package com.smile.controller.admin;

import com.github.pagehelper.PageInfo;
import com.smile.po.Type;
import com.smile.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * 分类视图控制
 * @Author: smile
 * @Date: 2020/1/20
 */
@Controller
@RequestMapping("admin")
public class TypesController {
    
    @Autowired
    TypeService typeService;
    
    /**
     * 静态页面跳转
     * @return
     */
    @GetMapping("types/inputs")
    public String typesInput(Model model) {
        model.addAttribute("type", new Type());
        return "admin/types-input";
    }
    
    /**
     * 查询所有分类
     * @param
     * @return
     */
    @GetMapping("types")
    public String listType(@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "1") Integer pageNum, Model model) {
        List<Type> types = typeService.listType(pageSize,pageNum);
        
        //分页信息分装
        PageInfo<Type> pageInfo = new PageInfo<>(types);
        model.addAttribute("pageInfo",pageInfo ) ;
        return "admin/types";
    }
    
    /**
     * 新增分类
     * @param type
     * @return
     */
    @PostMapping("types")
    public String insetType(Type type,RedirectAttributes redirectAttributes) {
        Type backType = typeService.getType(type);
        if (backType != null) {
            //提示信息回馈
            redirectAttributes.addFlashAttribute("message", "不能添加重复的分类");
            return "redirect:/admin/types/inputs";
        } else {
            typeService.insetType(type);
            redirectAttributes.addFlashAttribute("message", "操作成功");
            return "redirect:/admin/types";
        }
    }
    
    /**
     * 修改分类跳转页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("types/{id}/input")
    public String updateType(@PathVariable Long id, Model model) {
        Type type = new Type();
        type.setId(id);
        model.addAttribute("type", typeService.getType(type));
        return "admin/types-input";
    }
    
    /**
     * 修改分类
     * @param type
     * @return
     */
    @PostMapping("types/{id}")
    public String saveType(Type type, @PathVariable Long id,RedirectAttributes redirectAttributes) {
        Type backType = typeService.getType(type);
        if (backType == null) {
            typeService.updateType(type);
            //提示信息回馈
            redirectAttributes.addFlashAttribute("message", "操作成功");
            return "redirect:/admin/types";
        } else {
            redirectAttributes.addFlashAttribute("message", "操作失败");
            return "redirect:/admin/types";
        }
    }
    
    /**
     * 删除分类
     * @param id
     * @param redirectAttributes
     * @return
     */
    @GetMapping("types/{id}/delete")
    public String delteType(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Type type = new Type();
        type.setId(id);
        Type backType = typeService.getType(type);
        if (backType != null) {
            typeService.deleteType(type);
            //提示信息回馈
            redirectAttributes.addFlashAttribute("message", "操作成功");
            return "redirect:/admin/types";
        } else {
            redirectAttributes.addFlashAttribute("message", "操作失败");
            return "redirect:/admin/types";
        }
    }
  
    
}
