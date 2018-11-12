package com.call.application.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.call.application.domain.Department;
import com.call.application.service.base.DepartmentService;
import com.call.application.service.model.DepartmentModel;
import com.call.application.web.rest.base.DepartmentController;

@RestController
@RequestMapping("/api/departments")
public class SimpleDepartmentController extends SimpleCrudController<Department, DepartmentModel> implements DepartmentController{

	@Autowired
	public SimpleDepartmentController(DepartmentService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

}
