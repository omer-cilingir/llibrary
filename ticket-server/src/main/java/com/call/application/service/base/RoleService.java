package com.call.application.service.base;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.call.application.domain.Role;
import com.call.application.service.model.RoleModel;

public interface RoleService extends CrudService<Role, RoleModel> {
	@PreAuthorize("hasAuthority('ROLE_CREATE')")
	public RoleModel create(RoleModel model) throws MethodArgumentNotValidException;
}
