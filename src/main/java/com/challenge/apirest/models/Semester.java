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
@Table(name="TB_SEMESTER")
public class Semester implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private int totalCredits;
	@Column(nullable = false)
	private int numberSemester;
	
	public Semester() {
	}
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Discipline> discipline = new ArrayList<Discipline>();

	public Semester(long id, int totalCredits, int numberSemester, List<Discipline> discipline) {
		super();
		this.id = id;
		this.totalCredits = totalCredits;
		this.numberSemester = numberSemester;
		this.discipline = discipline;
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
	public int getNumberSemester() {
		return numberSemester;
	}
	public void setNumberSemester(int numberSemester) {
		this.numberSemester = numberSemester;
	}
	public List<Discipline> getDiscipline() {
		return discipline;
	}
	public void setDiscipline(List<Discipline> discipline) {
		this.discipline = discipline;
	}

	
	
}
