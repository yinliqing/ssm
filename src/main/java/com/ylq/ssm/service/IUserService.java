package com.ylq.ssm.service;

import java.util.List;

import com.ylq.ssm.pojo.User;

public interface IUserService {
	public User getUser(int id);
	public List<User> getUsers();
}
