package com.challenge.apirest.controllers;

import java.util.ArrayList;
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

import com.challenge.apirest.dto.DisciplineCourseDTO;
import com.challenge.apirest.dto.SemesterCourseDTO;
import com.challenge.apirest.models.Course;
import com.challenge.apirest.models.Discipline;
import com.challenge.apirest.models.Semester;
import com.challenge.apirest.repository.CourseRepository;
import com.challenge.apirest.repository.DisciplineRepository;
import com.challenge.apirest.repository.SemesterRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/api")
public class CourseController {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	DisciplineRepository disciplineRepository;
	
	@Autowired
	SemesterRepository semesterRepository;
	
	// Exibe todos os cursos
	@GetMapping("/courses")
	public List<Course> listCourses() {
		return courseRepository.findAll();
	}
	
	// Exibe um curso
	@GetMapping("/course/{id}")
	public Course showCourse(@PathVariable(value="id") long id) {
		return courseRepository.findById(id);
	}
	
	// Cria um curso
	@PostMapping("/course")
	public Course saveCourse(@RequestBody Course course) {
		return courseRepository.save(course);
	}
	
	// Deleta um curso
	@DeleteMapping("/course/{id}")
	public Course deleteCourse(@PathVariable(value="id") long id) {
		Course course = courseRepository.findById(id);
		courseRepository.delete(course);
		return course;
	}
	
	// Remove uma disciplina em um determinado curso
	@PostMapping("/course/discipline/remove")
	public Discipline removeDisciplineCourse(@RequestBody DisciplineCourseDTO discipline) {
		Discipline d = disciplineRepository.findById(discipline.getCourse_id());
		if(d.getCourse() == null) {
			return d;
		}
		if(d.getCourse().getId() == discipline.getCourse_id()) {
			d.setCourse(null);
		}
		
		disciplineRepository.save(d);
		return d;
	}
	
	// Adiciona um curso para um determinado usuário
	@PostMapping("/course/discipline/add")
	public Discipline addDisciplineCourse(@RequestBody DisciplineCourseDTO discipline) {
		List<Discipline> listDiscipline = new ArrayList<>();
		Discipline d = disciplineRepository.findById(discipline.getCourse_id());
		
		Course c = courseRepository.findById(discipline.getId());

		listDiscipline.add(d);
		c.setDiscipline(listDiscipline);
		d.setCourse(c);
		courseRepository.save(c);
		return d;
	}
	
	// Remove um curso em um determinado semestre
	@PostMapping("/course/semester/remove")
	public Course removeSemesterCourse(@RequestBody SemesterCourseDTO semester) {
		Long id_long = semester.getId(); 
		List<Semester> listSemester = new ArrayList<>();
		
		Course c = courseRepository.findById(semester.getCourse_id());
		listSemester = c.getSemester();

		for(int i = 0; i < listSemester.size(); i++) {
			if(listSemester.get(i).getId() == id_long) {
				listSemester.remove(i);
				break;
			}
		}
		
		c.setSemester(listSemester);
		courseRepository.save(c);
		
		return c;
	}
	
	// Adiciona um curso para um determinado semestre 
	@PostMapping("/course/semester/add")
	public Course addSemesterCourse(@RequestBody SemesterCourseDTO semester) {
		List<Semester> listSemester = new ArrayList<>();
		Semester s = semesterRepository.findById((long) semester.getId());
		
		Course c = courseRepository.findById(semester.getCourse_id());
		
		listSemester = c.getSemester();
		listSemester.add(s);
		
		c.setSemester(listSemester);
		courseRepository.save(c);
		
		return c;
	}
	

}
