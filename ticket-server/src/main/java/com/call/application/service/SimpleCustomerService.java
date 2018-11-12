package com.call.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.call.application.domain.Customer;
import com.call.application.repository.CustomerRepository;
import com.call.application.service.base.CustomerService;
import com.call.application.service.model.CustomerModel;

@Transactional(readOnly = true)
@Service
public class SimpleCustomerService extends SimpleCrudService<Customer, CustomerModel> implements CustomerService{

	@Autowired
	public SimpleCustomerService(CustomerRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}
}
