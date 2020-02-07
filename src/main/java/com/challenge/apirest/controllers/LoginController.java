package com.challenge.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.apirest.dto.UserLoginDTO;
import com.challenge.apirest.models.User;
import com.challenge.apirest.repository.UserRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/api")
public class LoginController {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/login")
	public User login(@RequestBody UserLoginDTO user) {
		User u = userRepository.findByEmail(user.getEmailLogin());
		if(u == null) {
			return null;
		}
	
		return u;
	} 
	
	
}
