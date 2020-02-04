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

import com.challenge.apirest.models.Subject;
import com.challenge.apirest.repository.SubjectRepository;

@RestController
@RequestMapping(value="/api")
public class SubjectController {
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@GetMapping("/subjects")
	public List<Subject> listSubject() {
		return subjectRepository.findAll();
	}
	
	@GetMapping("/subject/{id}")
	public Subject showSubject(@PathVariable(value="id") long id) {
		return subjectRepository.findById(id);
	}
	
	@PostMapping("/subject")
	public Subject saveSubject(@RequestBody Subject subject) {
		return subjectRepository.save(subject);
	}
	
	@DeleteMapping("/subject/{id}")
	public Subject deleteSubject(@PathVariable(value="id") long id) {
		Subject subject = subjectRepository.findById(id);
		subjectRepository.delete(subject);
		return subject;
	}

}
