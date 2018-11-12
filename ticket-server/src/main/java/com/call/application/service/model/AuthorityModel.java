package com.call.application.service.model;

import com.call.application.service.model.base.BaseModel;

public class AuthorityModel extends BaseModel {

	private String value;
	
	private String keyy;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getKey() {
		return keyy;
	}

	public void setKey(String keyy) {
		this.keyy = keyy;
	}

	@Override
	public String toString() {
		return String.format("AuthorityModel[id=%s, value=%s]", super.getId(), this.value);
	}
}
