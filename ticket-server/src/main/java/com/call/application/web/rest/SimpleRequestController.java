package com.call.application.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.call.application.domain.Request;
import com.call.application.service.base.RequestService;
import com.call.application.service.model.RequestModel;
import com.call.application.web.rest.base.RequestController;

@RequestMapping("/api/requests")
@RestController
public class SimpleRequestController extends SimpleCrudController<Request, RequestModel> implements RequestController{

	private final RequestService service;
	
	@Autowired
	public SimpleRequestController(RequestService service) {
		super(service);
		this.service = service;
	}
	
	@GetMapping("/me")
	public List<RequestModel> findByLoggedInUser() {
		return this.service.findRequestByLoggedInUser();
	}
}
