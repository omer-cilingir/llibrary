package com.call.application.web.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.call.application.domain.User;
import com.call.application.enums.UserType;
import com.call.application.service.base.UserService;
import com.call.application.service.model.UserModel;
import com.call.application.web.rest.base.UserController;



@RestController
@RequestMapping("/api/users")
public class SimpleUserController extends SimpleCrudController<User, UserModel> implements UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleUserController.class);

	private final UserService userService;

	@Autowired
	public SimpleUserController(UserService userService) {
		super(userService);
		this.userService = userService;
	}

	@RequestMapping(value = "/search/username={username}", method = RequestMethod.GET)
	@Override
	public UserModel findByUsername(@PathVariable("username") String username) {
		LOGGER.info("Finding user data with username: {}", username);

		UserModel userModel = userService.findByUsername(username);
		
		LOGGER.info("Found user data with information: {}", userModel);

		return userModel;
	}

	@RequestMapping(value = "/search/roleid={roleId}", method = RequestMethod.GET)
	@Override
	public List<UserModel> findByRole(@PathVariable("roleId") Long roleId) {
	
		LOGGER.info("Finding user data with roleId: {}", roleId);

		List<UserModel> userModels = userService.findByRoleId(roleId);
		
		LOGGER.info("Found user data with information: {}", userModels);
		
		return userModels;
	}

	@GetMapping("/me")
	@Override
	public UserModel getLoggedInUser() {
		return userService.getCurrentUser();
	}
	
	@GetMapping("/enums")
	@Override
	public List<UserType> userTypes() {
		return new ArrayList<UserType>(Arrays.asList(UserType.values()));
	}
}
