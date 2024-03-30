package com.ylq.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylq.ssm.mapper.UserMapper;
import com.ylq.ssm.pojo.User;
import com.ylq.ssm.service.IUserService;

@Service("userService")
public class IUserServiceImpl implements IUserService {
	//自动注入，因为在容器中有该mapper
    @Autowired
	private UserMapper userMapper;
    
	public User getUser(int id) {
		return userMapper.getUser(id);
	}

	public List<User> getUsers() {
		return userMapper.getUsers();
	}
}
