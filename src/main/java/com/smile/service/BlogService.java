package com.smile.service;

import com.smile.po.Blog;
import com.smile.vo.BlogQuery;


import java.util.List;
import java.util.Map;

/**
 * 博客管理业务层接口
 * @Author: smile
 * @Date: 2020/1/21
 */
public interface BlogService {
    
    /**
     * 通过blog主键查询一个对象,未转换HTML格式
     * @param id
     * @return
     */
    Blog getBlog(Long id);
    
    /**
     * 通过blog主键查询一个对象,转换成HTML格式
     * @param id
     * @return
     */
    public Blog getBlogAndConvert(Long id);
    
    /**
     * 分页查询blog对象
     * @param blog
     * @return
     */
    List<Blog> listBlogs(BlogQuery blog, int pageNum, int pageSize);
    
    /**
     * 更新blog-tag中间表
     * @param blog
     * @return
     */
    void insertBlogAndTag(Blog blog);
    
    /**
     * 添加博客
     * @param blog
     */
    int insertBlog(Blog blog);
    
    /**
     * 更新博客
     * @param blog
     */
    int updateBlog(Blog blog);
    
    /**
     * 删除博客
     * @param blog
     */
    int deleteBlog(Long blog);
    
    
    List<Blog> listAllBlog(Integer pageNum, Integer pageSize);
    
    /**
     * 获取最新推荐blog列表
     * @return
     */
    List<Blog> listNewBlog();
    
    /**
     * 搜索展示
     * @param pageNum
     * @param pageSize
     * @param query
     * @return
     */
    List<Blog> searchBlogs(Integer pageNum, Integer pageSize, String query);
    
    /**
     * 中间表查询全部
     * @param id
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Blog> listTagBlogCount(Long id, Integer pageNum, Integer pageSize);
    
    /**
     * 归档组合查询
     * @return
     */
    Map<String, List<Blog>> archive();
    
    /**
     * 查询所有博客数量
     * @return
     */
    int allBlogCouint();
}
