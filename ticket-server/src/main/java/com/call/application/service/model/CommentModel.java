package com.call.application.service.model;

import com.call.application.domain.Request;
import com.call.application.domain.User;
import com.call.application.service.model.base.BaseModel;

public class CommentModel extends BaseModel{

	private User user;
	
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
