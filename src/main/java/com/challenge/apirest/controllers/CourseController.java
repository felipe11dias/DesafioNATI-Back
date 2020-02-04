package com.challenge.apirest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.apirest.models.Course;
import com.challenge.apirest.models.User;
import com.challenge.apirest.repository.CourseRepository;
import com.challenge.apirest.repository.UserRepository;

@RestController
@RequestMapping(value="/api")
public class CourseController {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	UserRepository userRepository;
	
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
	
	// Cria e adiciona um curso para um determinado usuário
	@PostMapping("/course/user/new/{id}")
	public User newAddUserCourse(@RequestBody Course course, @PathVariable(value="id") long id) {
		List<Course> listCourse = new ArrayList<>();
		listCourse.add(course);			
		User u = userRepository.findById(id);
		u.setCourse(listCourse);
		userRepository.save(u);
		
		return u;
	}
	
	// Remove um curso de um determinado usuário
	@PostMapping("/course/user/remove/{id}")
	public User removeUserCourse(@RequestBody Course course, @PathVariable(value="id") long id) {
		Long id_long = course.getId(); 
		List<Course> listCourse = new ArrayList<>();
		
		User u = userRepository.findById(id);
		listCourse = u.getCourse();

		for(int i = 0; i < listCourse.size(); i++) {
			if(listCourse.get(i).getId() == id_long) {
				listCourse.remove(i);
				break;
			}
		}
		
		u.setCourse(listCourse);
		userRepository.save(u);
		
		return u;
	}
	
	// Adiciona um curso de um determinado usuário
	@PostMapping("/course/user/add/{id}")
	public User addUserCourse(@RequestBody Course course, @PathVariable(value="id") long id) {
		List<Course> listCourse = new ArrayList<>();
		
		Course c = courseRepository.findById((long) course.getId());
		
		User u = userRepository.findById(id);
		
		listCourse = u.getCourse();
		listCourse.add(c);
		
		u.setCourse(listCourse);
		userRepository.save(u);
		
		return u;
	}
}
