package com.challenge.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.apirest.models.Semester;

public interface SemesterRepository extends JpaRepository<Semester, Long> {
	
	Semester findById(long id);
	List<Semester> findAll();
}
