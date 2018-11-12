package com.call.application.web.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.call.application.domain.Employee;
import com.call.application.service.base.EmployeeService;
import com.call.application.service.model.EmployeeModel;
import com.call.application.web.rest.base.EmployeeController;

@RestController
@RequestMapping("/api/employees")
public class SimpleEmployeeController extends SimpleCrudController<Employee, EmployeeModel> implements EmployeeController{

	private final EmployeeService service;
	
	public SimpleEmployeeController(EmployeeService service) {
		super(service);
		this.service = service;
	}

	@GetMapping("/me")
	public List<EmployeeModel> findByManager() {
		List<EmployeeModel> list = this.service.findByManagerEmployee();
		for(EmployeeModel e : list){
			e.getUser().setRoles(null);
		}
		return list;
	}

	

	

}
