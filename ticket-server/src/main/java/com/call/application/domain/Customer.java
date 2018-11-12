package com.call.application.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.call.application.domain.base.BaseEntity;

@Entity
public class Customer extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Department department;
	
	@OneToOne
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
