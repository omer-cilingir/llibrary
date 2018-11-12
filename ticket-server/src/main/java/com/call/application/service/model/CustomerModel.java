package com.call.application.service.model;

import com.call.application.domain.Department;
import com.call.application.domain.User;
import com.call.application.service.model.base.BaseModel;

public class CustomerModel extends BaseModel{
	
	private Department department;
	
	private User user;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
