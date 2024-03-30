package com.ylq.ssm.service;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ylq.ssm.pojo.User;

@RunWith(SpringRunner.class)
// @SpringBootTest(classes = { LoginController.class, MockServletContext.class })
// @EnableAutoConfiguration
@ComponentScan(basePackages = { "com.ylq.ssm.*" })
@WebAppConfiguration // 声明测试加载WebApplicationContext
@ContextConfiguration({ "classpath:spring/applicationContext.xml" })
public class LoginTest {

	@Autowired
	WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@Before
	public void SetUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void login() throws Exception {
		RequestBuilder request = null;
		User user = new User();
		user.setId(100);
		user.setUserName("yinliqing");
		user.setName("YinLiQing");
		user.setPassword("1234567"); // 构造请求体JSON格式

		JSONObject userJSON = new JSONObject(user);
		String userJSONString = userJSON.toString();
		request = MockMvcRequestBuilders.post("/v1/login").contentType(MediaType.APPLICATION_JSON)
				.content(userJSONString);
		// String requestJson = mockMvc.perform(request).andDo(print())
		// .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		// System.out.println(requestJson);
		String requestJson = mockMvc.perform(request).andReturn().getResponse().getContentAsString();
		System.out.println(requestJson);
	}

}
