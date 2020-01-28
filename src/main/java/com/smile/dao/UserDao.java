package com.smile.dao;

import com.smile.po.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * user数据层接口
 * @Author: smile
 * @Date: 2020/1/20
 */
public interface UserDao extends Mapper<User>{
    
    
    @Select("select id,name,avatar from tb_user where id = #{id}")
    User selectByKey(Long id);
}
