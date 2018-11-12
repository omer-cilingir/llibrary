package com.call.application.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.call.application.domain.Role;
import com.call.application.service.base.RoleService;
import com.call.application.service.model.RoleModel;
import com.call.application.web.rest.base.RoleController;



@RestController
@RequestMapping("/api/roles")
public class SimpleRoleController extends SimpleCrudController<Role, RoleModel> implements RoleController {

	@Autowired
	public SimpleRoleController(RoleService roleService) {
		super(roleService);
	}

}
