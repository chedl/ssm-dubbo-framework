package com.chedl.service.user.mapper;

import com.chedl.entity.user.User;

public interface UserMapper {

    User selectByPrimaryKey(Integer id);
    
}