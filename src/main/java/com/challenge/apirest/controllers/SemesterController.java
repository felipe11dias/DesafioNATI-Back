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

import com.challenge.apirest.models.Semester;
import com.challenge.apirest.repository.SemesterRepository;

@RestController
@RequestMapping(value="/api")
public class SemesterController {
	
	@Autowired
	SemesterRepository semesterRepository;
	
	@GetMapping("/semesters")
	public List<Semester> listSemester() {
		return semesterRepository.findAll();
	}
	
	@GetMapping("/semester/{id}")
	public Semester showSemester(@PathVariable(value="id") long id) {
		return semesterRepository.findById(id);
	}
	
	@PostMapping("/semester")
	public Semester saveSemester(@RequestBody Semester semester) {
		return semesterRepository.save(semester);
	}
	
	@DeleteMapping("/semester/{id}")
	public Semester deleteSemester(@PathVariable(value="id") long id) {
		Semester semester = semesterRepository.findById(id);
		semesterRepository.delete(semester);
		return semester;
	}
	
}
