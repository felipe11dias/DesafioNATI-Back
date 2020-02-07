package com.challenge.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.apirest.models.Semester;
import com.challenge.apirest.repository.SemesterRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/api")
public class SemesterController {
	
	@Autowired
	SemesterRepository semesterRepository;
	
	// Exibe todos os semestres
	@GetMapping("/semesters")
	public List<Semester> listSemester() {
		return semesterRepository.findAll();
	}
	
	// Exibe um determinado semestre
	@GetMapping("/semester/{id}")
	public Semester showSemester(@PathVariable(value="id") long id) {
		return semesterRepository.findById(id);
	}
	
	// Cria um semestre
	@PostMapping("/semester")
	public Semester saveSemester(@RequestBody Semester semester) {
		return semesterRepository.save(semester);
	}
	
	// Exclui um semestre
	@DeleteMapping("/semester/{id}")
	public Semester deleteSemester(@PathVariable(value="id") long id) {
		Semester semester = semesterRepository.findById(id);
		semesterRepository.delete(semester);
		return semester;
	}
	
	
	
	
}
