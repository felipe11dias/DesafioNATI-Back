package com.challenge.apirest.dto;


public class UserDTO {
	
	private String name;
	private String email;
	private String gender;
	private int semester;
	private int type;
	
	public UserDTO(String name, String email, String gender, int semester, int type) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.semester = semester;
		this.type = type;
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

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	
	
}
