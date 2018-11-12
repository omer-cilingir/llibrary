package com.call.application.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.call.application.domain.Request;
import com.call.application.enums.UserType;
import com.call.application.repository.RequestRepository;
import com.call.application.service.base.RequestService;
import com.call.application.service.base.UserService;
import com.call.application.service.model.RequestModel;
import com.call.application.service.model.UserModel;

@Transactional(readOnly = true)
@Service
public class SimpleRequestService extends SimpleCrudService<Request, RequestModel> implements RequestService {

	private final RequestRepository repository;

	private final UserService userService;

	@Autowired
	public SimpleRequestService(RequestRepository repository, UserService userService) {
		super(repository);
		this.userService = userService;
		this.repository = repository;
	}

	@Override
	public List<UserType> userTypes() {
		return new ArrayList<UserType>(Arrays.asList(UserType.values()));
	}

	@Override
	public List<RequestModel> findRequestByLoggedInUser() {
		UserModel userModel = this.userService.getCurrentUser();
		switch (userModel.getUserType()) {
		case CUS:
			return this.findByCreatedBy(userModel.getUsername());
		case BUM:
			return this.findByUserUsername(userModel.getUsername());
		default:
			return this.findAll();
		}
		
	}

	@Override
	public List<RequestModel> findByCreatedBy(String createdBy) {
		return this.convertAll(this.repository.findByCreatedBy(createdBy));
	}

	@Override
	public List<RequestModel> findByUserUsername(String username) {
		return this.convertAll(this.repository.findByUserUsername(username));
	}
}
