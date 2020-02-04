package com.challenge.apirest.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TB_COURSE")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
    
	@OneToMany(mappedBy="curso", cascade=CascadeType.REMOVE)
	private List<Semester> semester = new ArrayList<>();

	@NotNull
	private int necessaryCredits = 0;
	@NotNull
	@Column(unique=true)
	private String name;
	
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
	public int getNecessaryCredits() {
		return necessaryCredits;
	}
	public void setNecessaryCredits(int necessaryCredits) {
		this.necessaryCredits = necessaryCredits;
	}
	public List<Semester> getSemester() {
		return semester;
	}
	public void setSemester(List<Semester> semester) {
		this.semester = semester;
	}
	

	
	
}
