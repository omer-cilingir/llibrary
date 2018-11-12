package com.call.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.call.application.domain.Employee;
import com.call.application.repository.EmployeeRepository;
import com.call.application.service.base.EmployeeService;
import com.call.application.service.base.UserService;
import com.call.application.service.model.EmployeeModel;
import com.call.application.service.model.UserModel;

@Transactional(readOnly = true)
@Service
public class SimpleEmployeeService extends SimpleCrudService<Employee, EmployeeModel> implements EmployeeService{

	EmployeeRepository repository;
	
	private final UserService userService;

	public SimpleEmployeeService(EmployeeRepository repository,UserService userService) {
		super(repository);
		this.repository = repository;
		this.userService = userService;
	}

	@Override
	public List<EmployeeModel> findByManagerEmployee() {
		UserModel userModel = this.userService.getCurrentUser();
		return this.findByIsManagerAndEmployeeUserUsername(false, userModel.getUsername());
	}

	@Override
	public List<EmployeeModel> findByIsManagerAndEmployeeUserUsername(Boolean isManager, String username) {
	
		return convertAll(this.repository.findByIsManagerAndEmployeeUserUsername(isManager, username));
	}
}
