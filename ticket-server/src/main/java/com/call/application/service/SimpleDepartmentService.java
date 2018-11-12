package com.call.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.call.application.domain.Department;
import com.call.application.repository.DepartmentRepository;
import com.call.application.service.base.DepartmentService;
import com.call.application.service.model.DepartmentModel;

@Service
public class SimpleDepartmentService extends SimpleCrudService<Department, DepartmentModel> implements DepartmentService{

	@Autowired
	public SimpleDepartmentService(DepartmentRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

}
