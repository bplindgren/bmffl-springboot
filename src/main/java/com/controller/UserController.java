package com.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("users")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
}
