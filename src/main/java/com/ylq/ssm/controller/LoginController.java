package com.ylq.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ylq.ssm.pojo.User;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		model.addAttribute("command", new User());
		// return new ModelAndView("user", "command", new User());
	    model.addAttribute("id", "");
	    model.addAttribute("userName", "");
		model.addAttribute("name", "");
		model.addAttribute("password", "");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String post(@ModelAttribute("/")User user, ModelMap model) {
		model.addAttribute("command", new User());
		// return new ModelAndView("user", "command", new User());
	    model.addAttribute("id", user.getId());
	    model.addAttribute("userName", user.getUserName());
		model.addAttribute("name", user.getName());
		model.addAttribute("password", user.getPassword());
		return "result";
	}
}
