package com.call.application.service.model;

import com.call.application.enums.UserType;
import com.call.application.service.model.base.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserModel extends BaseModel {

	private String firstname;

	private String lastname;

	private String username;

	@JsonIgnore
	private String password;

	private UserType userType;
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return String.format("UserModel[id=%s, firstname=%s, lastname=%s, username=%s]", super.getId(), this.firstname,
				this.lastname, this.username);
	}

}
