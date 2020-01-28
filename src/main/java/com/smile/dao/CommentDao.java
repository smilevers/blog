package com.smile.dao;

import com.smile.po.Comment;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 评论管理数据层接口
 * @Author: smile
 * @Date: 2020/1/26
 */
public interface CommentDao extends Mapper<Comment> {
    
    /**
     * 查询评论及所有父评论，根据博客id
     * @param blogId
     * @return
     */
    @Select("select * from tb_comment where blog_id = #{blogId} and parent_id = -1")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "blog_id",property = "blogId"),
            @Result(column = "parent_id",property = "parentId"),
            @Result(column = "id",property = "subComents",javaType = List.class,many = @Many(select = "com.smile.dao.CommentDao.listSubComentsById")),
            @Result(column = "parent_id",property = "parentComment",javaType = Comment.class,one = @One(select = "com.smile.dao.CommentDao.getComentsByparentId"))
    })
    List<Comment> listComments(Long blogId);
    
    /**
     * 查询所有子评论，根据父id
     * @param id
     * @return
     */
    @Select("select * from tb_comment where parent_id = #{id}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "blog_id",property = "blogId"),
            @Result(column = "parent_id",property = "parentId"),
            @Result(column = "id",property = "subComents",javaType = List.class,many = @Many(select = "com.smile.dao.CommentDao.listSubComentsById")),
            @Result(column = "parent_id",property = "parentComment",javaType = Comment.class,one = @One(select = "com.smile.dao.CommentDao.getComentsByparentId"))
    })
    List<Comment> listSubComentsById(Long id);
    
    /**
     * 查询父评论，根据父id
     * @param parent_id
     * @return
     */
    @Select("select * from tb_comment where id = #{parent_id}")
    Comment getComentsByparentId(Long parent_id);
}
