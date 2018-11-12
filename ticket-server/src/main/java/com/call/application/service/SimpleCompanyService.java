package com.call.application.service;

import org.springframework.stereotype.Service;

import com.call.application.domain.Company;
import com.call.application.repository.CompanyRepository;
import com.call.application.service.base.CompanyService;
import com.call.application.service.model.CompanyModel;

@Service
public class SimpleCompanyService extends SimpleCrudService<Company,CompanyModel> implements CompanyService{

	public SimpleCompanyService(CompanyRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

}
