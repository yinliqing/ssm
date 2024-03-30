package com.ylq.ssm.controller;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ylq.ssm.pojo.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1")
@Api(tags="登录验证")
public class LoginV1Controller {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ApiOperation("登录信息")
	@ApiImplicitParam(name="id", value="登录编号", required=true)
	public String login(@RequestParam(required=true) Long id) {
		// http://127.0.0.1:8080/ssm/v1/login?id=100
		System.out.println("/v1/login, get");
		User user = new User();
		user.setId(100);
		user.setUserName("Andrew1");
		user.setName("Andrew1");
		user.setPassword("1234567");
		JSONObject userJSON = new JSONObject(user);

		return userJSON.toString();
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("登录验证")
	public String post(@RequestBody User user, ModelMap model) {
		model.addAttribute("command", new User());
		// http://127.0.0.1:8080/ssm/v1/login
		// {"id": 100,"userName": "andrew2","name": "andrew2","password":  "123456"}
		// return new ModelAndView("user", "command", new User());
		System.out.println("/v1/login, post");
		System.out.println(user.getName());
		JSONObject userJSON = new JSONObject(user);
		
		return userJSON.toString();
	}
}
