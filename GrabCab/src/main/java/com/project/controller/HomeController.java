package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.model.User;
import com.project.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userservice;

	@RequestMapping("/welcome")
	public String welcome(HttpServletRequest request)
	{
		request.setAttribute("mode","MODE_HOME");
		return "welcome";
	}
	
	@RequestMapping("/register")
	public String registration(HttpServletRequest request)
	{
		request.setAttribute("mode","MODE_REGISTER");
		return "welcome";
	}
	
	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user,BindingResult bindingResult,HttpServletRequest request)
	{
		userservice.saveMyUser(user);
		request.setAttribute("mode","MODE_HOME");
		return "welcome";
	}

}
