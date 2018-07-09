package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.User;
import com.project.services.UserService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private UserService userService;
	
	
	
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("save-user")
	public String saveUser(@RequestParam String username,@RequestParam String firstname,@RequestParam String lastname,@RequestParam int age,@RequestParam String password)
	{
		User user=new User(username,firstname,lastname,age,password);
		userService.saveMyUser(user);
		return "user saved!";
	}

}
