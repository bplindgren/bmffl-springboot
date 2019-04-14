package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepo;

	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public List<User> getUsers() {
		return userRepo.findAll();
	}
	
	

}
