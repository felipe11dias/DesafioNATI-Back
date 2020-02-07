package com.challenge.apirest.dto;

import java.io.Serializable;

public class UserLoginDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String emailLogin;
	
	public UserLoginDTO(String emailLogin) {
		this.emailLogin = emailLogin;
	}
	
	public UserLoginDTO() {
	}

	public String getEmailLogin() {
		return emailLogin;
	}

	public void setEmailLogin(String emailLogin) {
		this.emailLogin = emailLogin;
	}
	
}