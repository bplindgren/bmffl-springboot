package com.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Role;
import com.entity.User;
import com.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User user) {
		if (userService.findByUsername(user.getUsername()) != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		user.setRole(Role.USER);
		userService.save(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@GetMapping("/login")
	public ResponseEntity<?> authenticate(Principal principal) {
		if (principal == null || principal.getName() == null) {
			return ResponseEntity.ok(principal);
		}
		return new ResponseEntity<>(
				userService.findByUsername(principal.getName()),
				HttpStatus.OK);
	}
	
}