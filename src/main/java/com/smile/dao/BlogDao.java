package com.smile.dao;

import com.smile.po.Blog;
import com.smile.po.Type;
import com.smile.po.User;
import com.smile.vo.BlogQuery;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 博客数据层接口
 * @Author: smile
 * @Date: 2020/1/21
 */
public interface BlogDao extends Mapper<Blog> {
    
    /**
     * 分页动态模糊查询blog对象
     * @param blog
     * @return
     */
    @Select("<script> "
                + " select * from tb_blog where 1 = 1 "
                + " <if test = 'title != null'> "
                + "  and title like concat('%',#{title},'%')  "
                + " </if> "
                + " <if test = 'typeId != null'> "
                + "  and type_id = #{typeId} "
                + " </if> "
                + " <if test = 'recommend != null'> "
                + "  and recommend = #{recommend} "
                + " </if> "
                + "</script>")
    @Results({
            @Result(column = "type_id" ,property = "typeId"),
            @Result(column = "user_id" ,property = "userId"),
            @Result(column = "type_id", property = "type", javaType = Type.class,one = @One(select = "com.smile.dao.TypeDao.selectByKey")),
            @Result(column = "user_id", property = "user", javaType = User.class,one = @One(select = "com.smile.dao.UserDao.selectByKey"))
    })
    
    /**
     * 查询条件
     */
    List<Blog> listBlogs(BlogQuery blog);
    
    /**
     * 根据type_Id外键查询
     * @param blog
     * @return
     */
    @Select("select * from blog where type_id = #{typeId}")
    List<Blog> getBlogs(Blog blog);
    
    /**
     * 插入blog_type中间表数据
     * @param blogId
     * @param tagId
     */
    @Insert("insert into tb_blog_tag values (#{blog_id},#{tag_id})")
    void insertBlogAndTag(@Param("blog_id") Long blogId, @Param("tag_id") Long tagId);
    
    /**
     * 删除blog_type中间表数据
     * @param blogId
     */
    @Delete("delete from  tb_blog_tag where blog_id = #{blog_id}")
    void deleteBlogAndTag(@Param("blog_id") Long blogId);
    
    /**
     * 查询中间表数量，确定不会插入多条
     * @param blogId
     * @param tagId
     * @return
     */
    @Select("select count(*) from tb_blog_tag where blog_id = #{blog_id} and tag_id = #{tag_id}  ")
    int getBlogAndTag(@Param("blog_id") Long blogId, @Param("tag_id") Long tagId);
    
    /**
     * 前端页面查询所有blog的type和User
     * @return
     */
    @Select("select * from tb_blog where published = true ")
    @Results({
            @Result(column = "type_id" ,property = "typeId"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "user_id",property = "user",javaType = User.class,one = @One(select="com.smile.dao.UserDao.selectByKey")),
            @Result(column = "type_id", property = "type", javaType = Type.class,one = @One(select = "com.smile.dao.TypeDao.selectByKey"))
    })
    List<Blog> selectAllBlogs();
    
    /**
     * 主键查询blog
     * @param id
     * @return
     */
    @Select("select * from tb_blog where id = #{id} ")
    @Results({
            @Result(column = "id" ,property = "id"),
            @Result(column = "type_id" ,property = "typeId"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "user_id",property = "user",javaType = User.class,one = @One(select="com.smile.dao.UserDao.selectByKey")),
            @Result(column = "type_id", property = "type", javaType = Type.class,one = @One(select = "com.smile.dao.TypeDao.selectByKey")),
            @Result(column = "id", property = "tagList", javaType = List.class,many = @Many(select = "com.smile.dao.TagDao.lisTagsById"))
    })
    Blog getblog(Long id);
    
    /**
     * 外键查询全部
     * @param id
     * @return
     */
    @Select("select * from tb_blog where type_id = #{id}")
    List<Blog> listTypeBlogCount(Long id);
    
    /**
     * 中间表查询全部
     * @param id
     * @return
     */
    @Select("select * from tb_blog where id in (select blog_id from tb_blog_tag where tag_id = #{id}) ")
    @Results({
            @Result(column = "id" ,property = "id"),
            @Result(column = "type_id" ,property = "typeId"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "user_id",property = "user",javaType = User.class,one = @One(select="com.smile.dao.UserDao.selectByKey")),
            @Result(column = "type_id", property = "type", javaType = Type.class,one = @One(select = "com.smile.dao.TypeDao.selectByKey")),
            @Result(column = "id", property = "tagList", javaType = List.class,many = @Many(select = "com.smile.dao.TagDao.lisTagsById"))
    })
    List<Blog> listTagBlogCount(Long id);
    
    /**
     * 前端页面搜索展示
     * @param query
     * @return
     */
    @Select("<script> "
            + " select * from tb_blog where published = true "
            + " <if test = 'query != null'> "
            + "  and (title like concat('%',#{query},'%') or content like concat('%',#{query},'%') )   "
            + " </if> "
            + "</script>")
    @Results({
            @Result(column = "id" ,property = "id"),
            @Result(column = "type_id" ,property = "typeId"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "user_id",property = "user",javaType = User.class,one = @One(select="com.smile.dao.UserDao.selectByKey")),
            @Result(column = "type_id", property = "type", javaType = Type.class,one = @One(select = "com.smile.dao.TypeDao.selectByKey")),
            @Result(column = "id", property = "tagList", javaType = List.class,many = @Many(select = "com.smile.dao.TagDao.lisTagsById"))
    })
    List<Blog> searchBlogs(@Param("query") String query);
    
    /**
     * 查询归档年份
     * @return
     */
    @Select("SELECT DATE_FORMAT(b.create_time,'%Y') as year FROM tb_blog b GROUP BY year ORDER BY year DESC")
    List<String> archiveYears();
    
    /**
     * 按归档年份查询blogs
     * @param year
     * @return
     */
    @Select("SELECT * from tb_blog b where DATE_FORMAT(b.create_time,'%Y') = #{year} ")
    List<Blog> archiveBlogs(String year);
    
    /**
     * 查询所有博客数量
     * @return
     */
    @Select("select count(*) from tb_blog")
    int allBlogCouint();
}
