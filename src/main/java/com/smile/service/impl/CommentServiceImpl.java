package com.smile.service.impl;

import com.smile.dao.CommentDao;
import com.smile.po.Comment;
import com.smile.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 评论管理业务层实现类
 * @Author: smile
 * @Date: 2020/1/26
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    
    @Autowired
    private CommentDao commentDao;
    
    /**
     * 用来分装所有子评论的集合
     */
    private List<Comment> subComments = new ArrayList<>();
    
    /**
     * 查询blog对应的父评论
     * @param blogId
     * @return
     */
    @Override
    public List<Comment> listComments(Long blogId) {
        List<Comment> comments = commentDao.listComments(blogId);
        // 循环遍历父评论，并且递归子评论
        for (Comment comment : comments) {
            if (comment.getSubComents().size() > 0) {
                for (Comment sub : comment.getSubComents()) {
                    this.getAllSunComments(sub);
                }
            }
            comment.setSubComents(subComments);
            subComments = new ArrayList<>();
        }
        
        return comments;
    }
    
    /**
     * 添加评论
     * @param comment
     */
    @Override
    public void saveCommnet(Comment comment) {
        commentDao.insert(comment);
    }
    
    /**
     * 递归获取所有子评论
     * @param comment
     */
    public void getAllSunComments(Comment comment) {
        subComments.add(comment);
        if (comment.getSubComents().size() > 0) {
            for (Comment subComment: comment.getSubComents()) {
                subComments.add(subComment);
                if (subComment.getSubComents().size() > 0) {
                    this.getAllSunComments(subComment);
                }
            }
        }
    }
}
