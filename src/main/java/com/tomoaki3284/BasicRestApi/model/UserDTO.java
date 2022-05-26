package com.tomoaki3284.BasicRestApi.model;

public class UserDTO {
	private String email;
	private String username;
	
	public UserDTO(User user) {
		this.email = user.getEmail();
		this.username = user.getUsername();
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}
