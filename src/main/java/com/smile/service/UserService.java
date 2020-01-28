package com.smile.service;

import com.smile.po.User;

/**
 * user业务层接口
 * @Author: smile
 * @Date: 2020/1/20
 */
public interface UserService {
    
    /**
     * 登陆接口
     * @param username
     * @param password
     * @return
     */
    User getUser(String username, String password);
}
