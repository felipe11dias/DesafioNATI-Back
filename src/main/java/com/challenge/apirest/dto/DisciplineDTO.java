package com.challenge.apirest.dto;

public class DisciplineDTO {
	
	private long id;
	private String name;
	private int credits;
	private long course_id;
	
	public DisciplineDTO(long id, String name, int credits, long course_id) {
		super();
		this.id = id;
		this.name = name;
		this.credits = credits;
		this.course_id = course_id;
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
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public long getCourse_id() {
		return course_id;
	}
	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}

}
