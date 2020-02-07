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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_COURSE")
public class Course implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
    
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Semester> semester = new ArrayList<Semester>();
	
	@OneToMany(mappedBy="course")
    private List<Discipline> discipline;
	
	public Course() {
	}
	
	@Column(nullable = false)
	private int necessaryCredits = 0;
	@Column(unique=true, nullable = false)
	private String name;
	@Column(nullable = false)
	private String shift;
	@Column(nullable = false)
	private int totalSemester;
	
	public Course(long id, List<Semester> semester, List<Discipline> discipline, int necessaryCredits, String name,
			String shift, int totalSemester) {
		super();
		this.id = id;
		this.semester = semester;
		this.discipline = discipline;
		this.necessaryCredits = necessaryCredits;
		this.name = name;
		this.shift = shift;
		this.totalSemester = totalSemester;
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
	public int getTotalSemester() {
		return totalSemester;
	}
	public void setTotalSemester(int totalSemester) {
		this.totalSemester = totalSemester;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public List<Discipline> getDiscipline() {
		return discipline;
	}
	public void setDiscipline(List<Discipline> discipline) {
		this.discipline = discipline;
	}
	
	
}
