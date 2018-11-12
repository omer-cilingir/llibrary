package com.call.application.service.model;

import com.call.application.domain.Company;
import com.call.application.service.model.base.BaseModel;

public class DepartmentModel extends BaseModel{
	
	private Company company;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
