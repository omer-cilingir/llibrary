package com.call.application.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.call.application.domain.base.BaseEntity;

@Entity
public class Employee extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@OneToOne
	private User user;
	
	@ManyToOne
	private Employee employee;
	
	@ManyToOne
	private Department department;
	
	private boolean isManager;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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
