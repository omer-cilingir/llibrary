package com.call.application.service.base;

import java.util.List;

import com.call.application.domain.Employee;
import com.call.application.service.model.EmployeeModel;
import com.google.common.base.Optional;

public interface EmployeeService extends CrudService<Employee, EmployeeModel>{

	List<EmployeeModel> findByManagerEmployee();
	
	List<EmployeeModel> findByIsManagerAndEmployeeUserUsername(Boolean isManager,String username);

}
