package com.call.application.web.rest.base;

import java.util.List;

import com.call.application.domain.Request;
import com.call.application.service.model.RequestModel;

public interface RequestController extends CrudController<Request, RequestModel>{
	List<RequestModel> findByLoggedInUser();
}
