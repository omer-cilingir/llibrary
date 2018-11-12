package com.call.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.call.application.domain.Role;
import com.call.application.repository.RoleRepository;
import com.call.application.service.base.RoleService;
import com.call.application.service.model.RoleModel;

@Transactional(readOnly = true)
@Service
public class SimpleRoleService extends SimpleCrudService<Role, RoleModel> implements RoleService {
	
	@Autowired
	public SimpleRoleService(RoleRepository roleRepository){
		super(roleRepository);
	}
	
}
