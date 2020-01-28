package com.smile.dao;

import com.smile.po.Blog;
import com.smile.po.Type;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 分类数据层接口
 * @Author: smile
 * @Date: 2020/1/20
 */
public interface TypeDao extends Mapper<Type> {
     
     /**
      * 主键查询一个type
      * @param id
      * @return
      */
     @Select("select * from tb_type where id = #{id}")
     Type selectByKey(Integer id);
     
     
     /**
      * 获取type排序列表，多表查询
      * @return
      */
     @Select("select t.id , t.name from tb_type t JOIN tb_blog b on b.type_id = t.id  GROUP BY id ORDER BY COUNT(t.id) desc ")
     @Results({
             @Result(column = "id" ,property = "id"),
             @Result(column = "t.name",property = "t.name"),
             @Result(column = "id",property = "blogs",javaType = List.class, many = @Many(select="com.smile.dao.BlogDao.listTypeBlogCount")),
     })
     List<Type> listSortType();
}
