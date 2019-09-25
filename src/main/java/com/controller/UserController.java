package com.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<User> register(@RequestBody User user) {
		// Check to make sure username doesn't already exist
		if (userService.findByUsername(user.getUsername()) != null) {
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		}
		
		user.setRole(Role.USER);
		user.setActive(true);
		userService.save(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@GetMapping("/login")
	public ResponseEntity<?> authenticate(Principal principal) {
		if (principal == null || principal.getName() == null) {
			return ResponseEntity.ok(principal);
		}
		return new ResponseEntity<User>(
				userService.findByUsername(principal.getName()),
				HttpStatus.OK);
	}
	
	@GetMapping("/user/{username}")
	public ResponseEntity<User> getUserInfo(@PathVariable String username) {
		User user = userService.findByUsername(username);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<?> updateUser(@PathVariable long id, @RequestBody User user) {
		User currentUser = userService.findById(id);
		if (currentUser == null) {
			return new ResponseEntity<String>(("Unable to upate. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
		} else {
			User updatedUser = userService.updateUser(user);
			return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
		}
	}
	
}
