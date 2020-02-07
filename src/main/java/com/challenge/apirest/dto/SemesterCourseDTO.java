package com.challenge.apirest.dto;

public class SemesterCourseDTO {
	
	private long id;
	private long course_id;
	
	public SemesterCourseDTO(long id, long course_id) {
		super();
		this.id = id;
		this.course_id = course_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}

	
	
}
