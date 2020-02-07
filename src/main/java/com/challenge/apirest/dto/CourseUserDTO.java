package com.challenge.apirest.dto;

public class CourseUserDTO {
	
	private long id;
	private String userEmail;

	public CourseUserDTO(long id, String userEmail ) {
		super();
		this.id = id;
		this.userEmail = userEmail;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
}
