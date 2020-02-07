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

import com.challenge.apirest.dto.DisciplineDTO;
import com.challenge.apirest.models.Discipline;
import com.challenge.apirest.repository.CourseRepository;
import com.challenge.apirest.repository.DisciplineRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/api")
public class DisciplineController {
	
	@Autowired
	DisciplineRepository disciplineRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	// Exibe todos as disciplinas
	@GetMapping("/disciplines")
	public List<Discipline> listDiscipline() {
		return disciplineRepository.findAll();
	}
	
	// Exibe uma determinada disciplina
	@GetMapping("/discipline/{id}")
	public Discipline showDiscipline(@PathVariable(value="id") long id) {
		return disciplineRepository.findById(id);
	}
	
	// Cria uma disciplina
	@PostMapping("/discipline")
	public Discipline saveDiscipline(@RequestBody DisciplineDTO discipline) {
		Discipline dis = new Discipline();
		dis.setId(discipline.getId());
		dis.setCredits(discipline.getCredits());
		dis.setName(discipline.getName());
		return disciplineRepository.save(dis);
	}
	
	// Exclui uma disciciplina
	@DeleteMapping("/discipline/{id}")
	public Discipline deleteDiscipline(@PathVariable(value="id") long id) {
		Discipline discipline = disciplineRepository.findById(id);
		disciplineRepository.delete(discipline);
		return discipline;
	}

}
