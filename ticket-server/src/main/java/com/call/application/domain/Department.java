package com.call.application.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.call.application.domain.base.BaseEntity;

@Entity
@Table(name = "department")
public class Department extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Company company;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
