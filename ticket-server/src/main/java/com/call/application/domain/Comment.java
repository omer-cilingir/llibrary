package com.call.application.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.call.application.domain.base.BaseEntity;

@Entity
public class Comment extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private User user;
	
	@ManyToOne
	private Request request;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
}
