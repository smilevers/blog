package com.smile.service.impl;

import com.smile.dao.UserDao;
import com.smile.po.User;
import com.smile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * use业务层
 * @Author: smile
 * @Date: 2020/1/20
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserDao userDao;
    
    /**
     * 登陆接口
     * @param username
     * @param password
     * @return
     */
    @Override
    public User getUser(String username, String password) {
        User requestUser = new User();
        requestUser.setUsername(username);
        requestUser.setPassword(password);
        return userDao.selectOne(requestUser);
        
    }
}
