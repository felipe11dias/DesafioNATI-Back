package com.challenge.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.apirest.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
	User findById(long id);
	User findByEmail(String email);
}
