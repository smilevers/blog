package com.smile.service.impl;

import com.github.pagehelper.PageHelper;
import com.smile.dao.BlogDao;
import com.smile.dao.TypeDao;
import com.smile.po.Blog;
import com.smile.po.Tag;
import com.smile.service.BlogService;
import com.smile.utils.MarkdownUtils;
import com.smile.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * 博客管理业务层实现类
 * @Author: smile
 * @Date: 2020/1/21
 */
@Service
@Transactional
public class BlogServiceImpl implements BlogService {
    
    @Autowired
    BlogDao blogDao;
    
    @Autowired
    TypeDao typeDao;
    
    
    /**
     * 通过blog主键查询一个对象,未转换HTML格式
     * @param id
     * @return
     */
    @Override
    public Blog getBlog(Long id) {
        Blog blog = blogDao.getblog(id);
        System.out.println(blog);
        StringBuffer tagStr = new StringBuffer();
        for (Tag tag : blog.getTagList()) {
            tagStr.append(tag.getId() + ",");
        }
        blog.setTagStr(tagStr.toString());
        return blog;
    }
    
    /**
     * 通过blog主键查询一个对象,转换成HTML格式
     * @param id
     * @return
     */
    @Override
    public Blog getBlogAndConvert(Long id) {
        Blog blog = blogDao.getblog(id);
        blog.setViews(blog.getViews()+1);
        blogDao.updateByPrimaryKey(blog);
        System.out.println(blog);
        StringBuffer tagStr = new StringBuffer();
        for (Tag tag : blog.getTagList()) {
            tagStr.append(tag.getId() + ",");
        }
        blog.setTagStr(tagStr.toString());
        String content = blog.getContent();
        blog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        return blog;
    }
    
    /**
     * 分页动态模糊查询blog对象
     * @param blog
     * @return
     */
    @Override
    public List<Blog> listBlogs(BlogQuery blog, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Blog> blogs = blogDao.listBlogs(blog);
        return blogs;
    }
    
    /**
     * 更新blog-tag中间表
     * @param blog
     * @return
     */
    @Override
    public void insertBlogAndTag(Blog blog) {
        blogDao.deleteBlogAndTag(blog.getId());
        for (Long id:blog.getTags()) {
            blogDao.insertBlogAndTag(blog.getId(),id);
        }
    }
    
    /**
     * 添加博客
     * @param blog
     */
    @Override
    public int insertBlog(Blog blog) {
        // 初始化博客信息
        blog.setViews(0);
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        return blogDao.insert(blog);
    }
    
    /**
     * 更新博客
     * @param blog
     */
    @Override
    public int updateBlog(Blog blog) {
        blog.setUpdateTime(new Date());
        return blogDao.updateByPrimaryKeySelective(blog);
    }
    
    /**
     * 删除博客
     * @param id
     */
    @Override
    public int deleteBlog(Long id) {
        blogDao.deleteBlogAndTag(id);
        return blogDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 前端分页展示全部blog
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<Blog> listAllBlog(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Blog> blogs = blogDao.selectAllBlogs();
        return blogs;
        
    }
    
    /**
     * 获取最新推荐blog列表
     * @return
     */
    @Override
    public List<Blog> listNewBlog() {
        Example example = new Example(Blog.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("recommend", true);
        example.orderBy("updateTime").desc();
        PageHelper.startPage(1, 6);
        List<Blog> blogList = blogDao.selectByExample(example);
        return blogList;
    }
    
    /**
     * 搜索展示
     * @param pageNum
     * @param pageSize
     * @param query
     * @return
     */
    @Override
    public List<Blog> searchBlogs(Integer pageNum, Integer pageSize, String query) {
        PageHelper.startPage(pageNum, pageSize);
        List<Blog> blogs =  blogDao.searchBlogs(query);
        return blogs;
    }
    
    /**
     * 中间表查询全部
     * @param id
     * @return
     */
    @Override
    public List<Blog> listTagBlogCount(Long id, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return blogDao.listTagBlogCount(id);
    }
    
    /**
     * 归档组合查询
     * @return
     */
    @Override
    public Map<String, List<Blog>> archive() {
        List<String> years = blogDao.archiveYears();
        Map<String, List<Blog>> map = new LinkedHashMap<>();
        for (String year : years) {
            List<Blog> blogs = blogDao.archiveBlogs(year);
            map.put(year, blogs);
        }
        return map;
    }
    
    /**
     * 查询所有博客数量
     * @return
     */
    @Override
    public int allBlogCouint() {
        return blogDao.allBlogCouint();
    }
}
