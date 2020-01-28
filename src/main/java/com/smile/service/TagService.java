package com.smile.service;

import com.smile.po.Tag;

import java.util.List;

/**
 * 标签业务层接口
 * @Author: smile
 * @Date: 2020/1/24
 */
public interface TagService {
    
    Tag getTag(Long id);
    
    List<Tag> listTag(Integer pageNum, Integer pageSize);
    
    int insertTag(Tag tag);
    
    int updateTag(Tag tag);
    
    int deleteTag(Long tag);
    
    
    List<Tag> listTags();
    
    
    List<Tag> listSortTag(Integer pageNum, Integer pageSize);
}
