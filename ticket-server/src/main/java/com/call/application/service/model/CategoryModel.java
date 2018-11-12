package com.call.application.service.model;

import com.call.application.service.model.base.BaseModel;

public class CategoryModel extends BaseModel {
	
	private String categoryName;
	
	private UserModel user;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
		
	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return String.format("CategoryModel[categoryName=%s]", this.categoryName);
	}

}
