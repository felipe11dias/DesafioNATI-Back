package com.challenge.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.apirest.models.User;
import com.challenge.apirest.repository.UserRepository;

@RestController
@RequestMapping(value="/api")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> listUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User showUser(@PathVariable(value="id") long id) {
		return userRepository.findById(id);
	}
	
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@DeleteMapping("/user/{id}")
	public User deleteUser(@PathVariable(value="id") long id) {
		User user = userRepository.findById(id);
		userRepository.delete(user);
		return user;
	}
}
