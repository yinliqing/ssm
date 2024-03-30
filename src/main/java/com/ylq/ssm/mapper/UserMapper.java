package com.ylq.ssm.mapper;

import java.util.List;

import com.ylq.ssm.pojo.User;

public interface UserMapper {
	public User getUser(int id);
	public List<User> getUsers();
}
