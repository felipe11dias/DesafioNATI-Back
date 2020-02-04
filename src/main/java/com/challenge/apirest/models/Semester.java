package com.challenge.apirest.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TB_SEMESTER")
public class Semester implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	
	@ManyToMany
	@JoinTable(name="tb_semester_subject", 
		joinColumns= { @JoinColumn(name="semester_id") },
		inverseJoinColumns= { @JoinColumn(name="subject_id") })
	private List<Subject> subject = new ArrayList<>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private int totalCredits;
	@NotNull
	private int numberSemester;
	
	public Semester() {
	}
	
	public Semester(Course course, List<Subject> subject, long id, @NotNull int totalCredits, @NotNull int numberSemester) {
		super();
		this.course = course;
		this.subject = subject;
		this.id = id;
		this.totalCredits = totalCredits;
		this.numberSemester = numberSemester;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getTotalCredits() {
		return totalCredits;
	}
	public void setTotalCredits(int totalCredits) {
		this.totalCredits = totalCredits;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Subject> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}

	public int getNumberSemester() {
		return numberSemester;
	}

	public void setNumberSemester(int numberSemester) {
		this.numberSemester = numberSemester;
	}
	
	
}
