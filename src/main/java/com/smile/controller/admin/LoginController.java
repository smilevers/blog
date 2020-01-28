package com.smile.controller.admin;

import com.smile.po.User;
import com.smile.service.UserService;
import com.smile.utils.MD5Uitls;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 控制用户的登陆
 * @Author: smile
 * @Date: 2020/1/20
 */
@Controller
@RequestMapping("admin")
public class LoginController {
    
    @Autowired
    UserService userService;

    /**
     * 登陆接口
     * @param username
     * @param password
     * @return
     */
    @PostMapping("login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session, RedirectAttributes redirectAttributes) {
        
        //接收数据的非空判断
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return "redirect:/admin";
        }
        //查询数据库的用户和密码（使用MD5加密）
        User user = userService.getUser(username, MD5Uitls.code(password));
        if (user != null) {
            //情况sessin中的密码，不返回给客户端
            user.setPassword(null);
            session.setAttribute("user", user);
            return "admin/index";
        } else {
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误");
            //重定向到登录页
            return "redirect:/admin";
        }
    }
    
    
    
    /**
     * 登出接口
     * @param session
     * @return
     */
    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
