package com.challenge.apirest.models;

import java.util.Set;

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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@OneToMany(mappedBy = "course")
    Set<Matriculation> matriculation;
    
    @OneToMany(mappedBy = "course")
    Set<Semester> semester;

	@NotNull
	private int amountCourse;
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
	public int getAmountCourse() {
		return amountCourse;
	}
	public void setAmountCourse(int amountCourse) {
		this.amountCourse = amountCourse;
	}
	public Set<Matriculation> getMatriculation() {
		return matriculation;
	}
	public void setMatriculation(Set<Matriculation> matriculation) {
		this.matriculation = matriculation;
	}
	
	
}
