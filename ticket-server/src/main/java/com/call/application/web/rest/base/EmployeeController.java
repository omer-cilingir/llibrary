package com.call.application.web.rest.base;

import java.util.List;

import com.call.application.domain.Employee;
import com.call.application.service.model.EmployeeModel;

public interface EmployeeController extends CrudController<Employee, EmployeeModel>{
	List<EmployeeModel> findByManager();
}
