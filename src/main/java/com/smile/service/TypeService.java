package com.smile.service;

import com.smile.po.Type;

import java.util.List;

/**
 * 分类业务层接口
 * @Author: smile
 * @Date: 2020/1/20
 */
public interface TypeService {
    
    /**
     * 根据主键查询一个分类
     * @param type
     * @return
     */
    Type getType(Type type);
    
    /**
     * 查询所有分类
     * @return
     * @param pageSize
     * @param pageNum
     */
    List<Type> listType(Integer pageSize, Integer pageNum);
    
    /**
     * 新增分类
     * @param type
     */
    void insetType(Type type);
    
    /**
     * 修改分类
     * @param type
     */
    void updateType(Type type);
    
    /**
     * 删除分类
     * @param type
     */
    void deleteType(Type type);
    
    /**
     * 查询所有
     * @return
     */
    List<Type> listTypes();
    
    /**
     * 获取type排序列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Type> listSortType(Integer pageNum,Integer pageSize);
}
