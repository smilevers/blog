package com.smile.dao;

import com.smile.po.Tag;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 标签数据层接口
 * @Author: smile
 * @Date: 2020/1/24
 */
public interface TagDao extends Mapper<Tag>{
    
    /**
     * 获取tags排序列表
     * @return
     */
    @Select("select t.id ,t.name  FROM tb_blog_tag \n"
            + "JOIN tb_blog b ON b.id = blog_id \n"
            + "JOIN tb_tag t on t.id = tag_id GROUP BY id ORDER BY COUNT(t.id) desc ")
    @Results({
            @Result(column = "id" ,property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "id",property = "blogs",javaType = List.class, many = @Many(select="com.smile.dao.BlogDao.listTagBlogCount")),
    })
    List<Tag> listSortTag();
    
    /**
     * 中间表查询全部
     * @param id
     * @return
     */
    @Select("select * from tb_tag  where id in (select tag_id from tb_blog_tag where blog_id = #{id})")
    List<Tag> lisTagsById(Long id);
}
