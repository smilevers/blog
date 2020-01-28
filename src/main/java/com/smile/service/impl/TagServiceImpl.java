package com.smile.service.impl;

import com.github.pagehelper.PageHelper;
import com.smile.dao.TagDao;
import com.smile.po.Tag;
import com.smile.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 标签业务层实现类
 * @Author: smile
 * @Date: 2020/1/24
 */
@Service
public class TagServiceImpl implements TagService {
    
    @Autowired
    private TagDao tagDao;
    
    /**
     * 查询一个tag
     * @param id
     * @return
     */
    @Override
    public Tag getTag(Long id) {
        return tagDao.selectByPrimaryKey(id);
    }
    
    /**
     * 分页查询所有tags
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<Tag> listTag(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return tagDao.selectAll();
    }
    
    /**
     * 新增tag
     * @param tag
     * @return
     */
    @Override
    public int insertTag(Tag tag) {
        return tagDao.insert(tag);
    }
    
    /**
     * 更新tag
     * @param tag
     * @return
     */
    @Override
    public int updateTag(Tag tag) {
        return tagDao.updateByPrimaryKey(tag);
    }
    
    /**
     * 删除tag
     * @param id
     * @return
     */
    @Override
    public int deleteTag(Long id) {
        return tagDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 查询全部
     * @return
     */
    @Override
    public List<Tag> listTags() {
        return tagDao.selectAll();
    }
    
    /**
     * 获取tags排序列表
     * @return
     * @param pageNum
     * @param pageSize
     */
    @Override
    public List<Tag> listSortTag(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Tag> tags = tagDao.listSortTag();
        return tags;
    }
}
