package com.call.application.service.base;

import java.util.List;

import com.call.application.domain.Request;
import com.call.application.enums.UserType;
import com.call.application.service.model.RequestModel;

public interface RequestService extends CrudService<Request, RequestModel>{

	List<UserType> userTypes();
	
	List<RequestModel> findRequestByLoggedInUser();

	List<RequestModel> findByCreatedBy(String createdBy);
	
	List<RequestModel> findByUserUsername(String username);
}
