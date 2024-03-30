package com.ylq.ssm.service;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ylq.ssm.pojo.User;

public class IUserServiceTestMain {

	public static void main(String[] args) {
		ApplicationContext application = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		IUserService uService = (IUserService) application.getBean("userService");
		User user = uService.getUser(1);
		assertEquals("andrew", user.getUserName());  // 断言
		Logger.getLogger(IUserServiceTestMain.class).log(Level.INFO, user.getUserName());
		System.out.println(user.getUserName());
	}
}
