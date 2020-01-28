package com.smile.service.impl;

import com.github.pagehelper.PageHelper;
import com.smile.dao.TypeDao;
import com.smile.po.Type;
import com.smile.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 分类业务层实现类
 * @Author: smile
 * @Date: 2020/1/20
 */
@Service
@Transactional
public class TypeServiceImpl implements TypeService {
    
    
    @Autowired
    TypeDao typeDao;
    
    /**
     * 根据主键查询一个分类
     * @param type
     * @return
     */
    @Override
    public Type getType(Type type) {
        return typeDao.selectOne(type);
    }
    
    /**
     * 查询所有分类
     * @return
     * @param pageSize
     * @param pageNum
     */
    @Override
    public List<Type> listType(Integer pageSize, Integer pageNum) {
        
        //分页助手
        PageHelper.startPage(pageNum, pageSize);
        List<Type> types = typeDao.selectAll();
        return types;
    }
    
    /**
     * 新增分类
     * @param type
     */
    @Override
    public void insetType(Type type) {
        typeDao.insert(type);
    }
    
    /**
     * 修改分类
     * @param type
     */
    @Override
    public void updateType(Type type) {
        typeDao.updateByPrimaryKey(type);
    }
    
    /**
     * 删除分类
     * @param type
     */
    @Override
    public void deleteType(Type type) {
        typeDao.delete(type);
    }
    
    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Type> listTypes() {
        return typeDao.selectAll();
    }
    
    /**
     * 获取type排序列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<Type> listSortType(Integer pageNum,Integer pageSize) {
    
        PageHelper.startPage(pageNum, pageSize);
        List<Type> types = typeDao.listSortType();
        return types;
    }
    
    
}
