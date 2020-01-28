package com.smile.service;

import com.smile.po.Comment;

import java.util.List;

/**
 * 评论管理业务层接口
 * @Author: smile
 * @Date: 2020/1/26
 */
public interface CommentService {
    
    /**
     * 查询blog对应的评论
     * @param blogId
     * @return
     */
    List<Comment> listComments(Long blogId);
    
    /**
     * 添加评论
     * @param comment
     */
    void saveCommnet(Comment comment);
}
