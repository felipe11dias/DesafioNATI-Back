package com.challenge.apirest.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="TB_USER")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Course> course = new ArrayList<Course>();
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Discipline> discipline = new ArrayList<Discipline>();
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false)
	private int semester;
	@Column(nullable = false)
	private int type;
	
	public User() {
	}

	public User(long id, List<Course> course, String name, String email, String gender, int semester, int type) {
		super();
		this.id = id;
		this.course = course;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.semester = semester;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	public List<Discipline> getDiscipline() {
		return discipline;
	}

	public void setDiscipline(List<Discipline> discipline) {
		this.discipline = discipline;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}
	

}
