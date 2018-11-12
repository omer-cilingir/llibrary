package com.call.application.service.model;

import com.call.application.domain.Department;
import com.call.application.domain.Employee;
import com.call.application.domain.User;
import com.call.application.service.model.base.BaseModel;

public class EmployeeModel extends BaseModel{
	
	private User user;
	
	private Employee employee;
	
	private Department department;
	
	private boolean isManager;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	
}
