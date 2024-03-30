package com.ylq.ssm.service;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ylq.ssm.pojo.User;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 * 
 * 单元测试提示如下信息：
 * ERROR StatusLogger No log4j2 configuration file found. Using default configuration: logging only errors to the console.
 * 
 * 解决方法是将log4j2.xml文件放在src/main/resources目录下
 * 
 * JUnit使用JUnit4版本
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@WebAppConfiguration
@ContextConfiguration({ "classpath:spring/applicationContext.xml"})
public class IUserServiceTest {

	@Autowired
	public IUserService userService;
	
	@Test
	public void getUserTest(){
		User user = userService.getUser(1);
		assertEquals("andrew", user.getUserName());  // 断言Logger.getLogger(IUserServiceTestMain.class).log(Level.INFO, user.getUserName());
		Logger.getLogger(IUserServiceTestMain.class).log(Level.INFO, user.getUserName());
		System.out.println(user.getUserName());
	}
}
