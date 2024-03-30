package com.ylq.ssm.controller;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ylq.ssm.pojo.User;
import com.ylq.ssm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
    private IUserService userService;
    
    @RequestMapping(value="")
    public String findUser(@RequestParam("id") String id, ModelMap model) {
        User user = userService.getUser(Integer.valueOf(id));
        Logger.getLogger(UserController.class).log(Level.INFO, user.getUserName());
        System.out.println(user);
        model.addAttribute("command", new User());
		// return new ModelAndView("user", "command", new User());
	    model.addAttribute("user", user);
        return "user";
    }
    
    @RequestMapping(value="/list")
    @ResponseBody
    public String findUsers() {
        List<User> users = userService.getUsers();
        System.out.println(users);
        return users.toString();
    }
    
    @RequestMapping("xxxTest")
    public ModelAndView getTestHtml() {
        System.out.println("=======================================");
        return new ModelAndView("test.html");
    }

}
