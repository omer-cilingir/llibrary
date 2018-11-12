package com.call.application.domain.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class ValueEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(unique = true)
	private String code;
	
	private String value;
		
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
