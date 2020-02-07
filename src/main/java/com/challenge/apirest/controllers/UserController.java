package com.challenge.apirest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.apirest.dto.CourseUserDTO;
import com.challenge.apirest.dto.UserDTO;
import com.challenge.apirest.models.Course;
import com.challenge.apirest.models.Semester;
import com.challenge.apirest.models.User;
import com.challenge.apirest.repository.CourseRepository;
import com.challenge.apirest.repository.SemesterRepository;
import com.challenge.apirest.repository.UserRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/api")
public class UserController {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SemesterRepository semesterRepository;
	
	// Exibe todos os usuarios
	@GetMapping("/users")
	public List<User> listUsers() {
		return userRepository.findAll();
	}
	// Exibe um determinado usuario
	@GetMapping("/user/{id}")
	public User showUser(@PathVariable(value="id") long id) {
		return userRepository.findById(id);
	}
	// Cria um usuario
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	// Atualiza um usuario
	@PutMapping("/user/{id}")
	public User updateUser(@RequestBody UserDTO user, @PathVariable(value="id") long id) {
		User u = userRepository.findById(id);
		if(user.getEmail() != null) {
			u.setEmail(user.getEmail());
		}
		if(user.getName() != null) {
			u.setName(user.getName());
		}
		if(user.getGender() != null) {
			u.setGender(user.getGender());
		}
		if(user.getSemester() < 0) {
			u.setSemester(user.getSemester());
		}
		if(user.getType() < 0) {
			u.setType(user.getType());
		}
		
		return userRepository.save(u);
	}
	
	// Exclui um usuario
	@DeleteMapping("/user/{id}")
	public User deleteUser(@PathVariable(value="id") long id) {
		User user = userRepository.findById(id);
		userRepository.delete(user);
		return user;
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
	
	// Exibe todos os cursos de um usuario
	@GetMapping("/courses/user/{id}")
	public List<Course> listUserCourses(@PathVariable(value="id") long id) {
		
		User user = userRepository.findById(id);
		
		return user.getCourse();
	}
	
	// Remove um curso em um determinado usuário
	@PostMapping("/course/user/remove")
	public User removeUserCourse(@RequestBody CourseUserDTO course) {
		Long id_long = course.getId(); 
		List<Course> listCourse = new ArrayList<>();
		
		User u = userRepository.findByEmail(course.getUserEmail());
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
	
	// Adiciona um curso para um determinado usuário 
	@PostMapping("/course/user/add")
	public User addUserCourse(@RequestBody CourseUserDTO course) {
		List<Course> listCourse = new ArrayList<>();
		Course c = courseRepository.findById((long) course.getId());
		
		User u = userRepository.findByEmail(course.getUserEmail());
		
		listCourse = u.getCourse();
		listCourse.add(c);
		
		u.setCourse(listCourse);
		userRepository.save(u);
		
		return u;
	}
	
//	@GetMapping("/course/user/semester/{id}")
//	public List<Semester> listUserSemester(@PathVariable(value="id") long id) {
//		List<Semester> listSemester = new ArrayList<>();
//		listSemester = semesterRepository.findAll();
//		
//		User user = userRepository.findById(id);
//		for(int i = 0; i < user.getDiscipline().size(); i++) {
//			for(int j = 0; j < listSemester.size(); j++) {
//				for(int k = 0; k < listSemester.get(k).getDiscipline().size(); k++) {
//					if(user.getDiscipline().get(i).getId() == listSemester.get(j).getDiscipline().get(k).getId() ) {
//						listSemester.add(e)
//					}									
//				}
//			}
//		}
//		user.getDiscipline()
//		return null;
//	}
}
