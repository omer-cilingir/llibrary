package com.call.application.exception;

import com.call.application.exception.base.BaseException;

public class EntityNotFoundException extends BaseException {

	private static final long serialVersionUID = -3443431232372230273L;

	public EntityNotFoundException(String entityName, String field, String data) {
		super(String.format("No %s data found with %s: [%s]", entityName, field, data));
	}

}
