package com.challenge.apirest.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="TB_MATRICULATION")
public class Matriculation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
 
    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;    

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}