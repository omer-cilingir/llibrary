package com.call.application.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.call.application.domain.Customer;
import com.call.application.service.base.CustomerService;
import com.call.application.service.model.CustomerModel;
import com.call.application.web.rest.base.CustomerController;

@RestController
@RequestMapping("/api/customers")
public class SimpleCustomerController extends SimpleCrudController<Customer, CustomerModel> implements CustomerController{

	@Autowired
	public SimpleCustomerController(CustomerService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

}
