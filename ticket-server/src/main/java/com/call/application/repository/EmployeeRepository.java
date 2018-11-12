package com.call.application.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.call.application.domain.Employee;
import com.call.application.repository.base.BaseRepository;
import com.call.application.service.model.EmployeeModel;
import com.google.common.base.Optional;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee>{
	
	List<Employee> findByIsManagerAndEmployeeUserUsername(Boolean isManager,String username);
}
