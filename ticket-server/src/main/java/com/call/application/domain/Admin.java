package com.call.application.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.call.application.domain.base.BaseEntity;

@Entity
public class Admin extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	private User user;
	
	@ManyToOne
	private Department department;
}
