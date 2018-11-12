package com.call.application.web.rest.base;

import java.util.List;

import com.call.application.domain.User;
import com.call.application.enums.UserType;
import com.call.application.service.model.UserModel;



public interface UserController extends CrudController<User, UserModel> {
	public UserModel findByUsername(String username);
	public List<UserModel> findByRole(Long roleId);
	public UserModel getLoggedInUser();
	public List<UserType> userTypes();	
}
