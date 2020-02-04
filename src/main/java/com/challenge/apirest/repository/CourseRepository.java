package com.challenge.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.apirest.models.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	
	Course findById(long id);
}
