package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	public User findById(long id) {
		return userRepository.findById(id);
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public User save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return user;
	}
	
	public User updateUser(User updatedUser) {
		User existingUser = userRepository.findById(updatedUser.getId())
                .orElse(null);
			
		System.out.println(updatedUser);
		existingUser.setFirstname(updatedUser.getFirstname());
		existingUser.setLastname(updatedUser.getLastname());
		existingUser.setEmail(updatedUser.getEmail());
		existingUser.setFavbmfflteam(updatedUser.getFavbmfflteam());
		existingUser.setFavnflteam(updatedUser.getFavnflteam());
		
		User savedUser = userRepository.save(existingUser);
		return savedUser;
	}

}
