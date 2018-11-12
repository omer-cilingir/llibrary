package com.call.application.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.call.application.domain.base.BaseEntity;

@Entity
@Table(name = "company")
public class Company extends BaseEntity{

	private static final long serialVersionUID = 1L;

}
