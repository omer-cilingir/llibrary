package com.call.application.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.call.application.domain.base.BaseEntity;

@Entity
@Table(name = "category")
public class Category extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	@Size(max=20)
	String categoryName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	User user;
	
	public Category() {
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return String.format("Category[categoryName=%s]",
				this.categoryName);
	}
}
