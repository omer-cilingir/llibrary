package com.call.application.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.call.application.domain.Company;
import com.call.application.service.base.CompanyService;
import com.call.application.service.model.CompanyModel;
import com.call.application.web.rest.base.CompanyController;

@RestController
@RequestMapping("/api/companies")
public class SimpleCompanyController extends SimpleCrudController<Company, CompanyModel> implements CompanyController{

	public SimpleCompanyController(CompanyService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}
}
