package com.call.application.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.call.application.domain.base.ValueEntity;

@Entity
@Table(name = "authority")
public class Authority extends ValueEntity {

	private static final long serialVersionUID = 1L;

	private String keyy;

	public String getKeyy() {
		return keyy;
	}

	public void setKeyy(String keyy) {
		this.keyy = keyy;
	}
}
