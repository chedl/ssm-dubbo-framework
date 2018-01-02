package com.chedl.service.user.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chedl.entity.user.User;
import com.chedl.service.user.UserService;
import com.chedl.service.user.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Resource  
    private UserMapper userMapper; 

	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(userId);  
	}
}
