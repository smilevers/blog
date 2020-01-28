package com.smile.controller;

import com.smile.po.Comment;
import com.smile.po.User;
import com.smile.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 评论管理视图层
 * @Author: smile
 * @Date: 2020/1/26
 */
@Controller
public class CommentController {
    
    @Autowired
    private CommentService commentService;
    
    @Value("${comment.avatar}")
    private String avatar;
    
    /**
     * 获取blog评论
     * @param blogId
     * @param model
     * @return
     */
    @GetMapping("/comments/{blogId}")
    public String listCommnets(@PathVariable Long blogId, Model model) {
        System.out.println(blogId);
        List<Comment> comments = commentService.listComments(blogId);
        model.addAttribute("comments", comments);
        return "blog :: commentList";
    }
    
    /**
     * 保存blog评论，并加载评论到评论区
     * @param comment
     * @return
     */
    @PostMapping("/comments")
    public String saveComment(Comment comment, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            comment.setAvatar(user.getAvatar());
            comment.setAdmin(true);
            comment.setNickname(user.getName());
        } else {
            comment.setAvatar(avatar);
            comment.setAdmin(false);
        }
        System.out.println(comment);
        comment.setCreateTime(new Date());
        commentService.saveCommnet(comment);
        return "redirect:/comments/" + comment.getBlogId();
    }
}
