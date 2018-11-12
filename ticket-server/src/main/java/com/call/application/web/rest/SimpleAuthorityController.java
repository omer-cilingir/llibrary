package com.call.application.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.call.application.domain.Authority;
import com.call.application.service.base.AuthorityService;
import com.call.application.service.model.AuthorityModel;
import com.call.application.web.rest.base.AuthorityController;

@RestController
@RequestMapping("/api/authorities")
public class SimpleAuthorityController extends SimpleCrudController<Authority, AuthorityModel> implements AuthorityController {

	@Autowired
	public SimpleAuthorityController(AuthorityService authorityService) {
		super(authorityService);
	}

}
