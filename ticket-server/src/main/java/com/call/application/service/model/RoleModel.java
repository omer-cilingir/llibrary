package com.call.application.service.model;

import com.call.application.service.model.base.BaseModel;

public class RoleModel extends BaseModel {

	@Override
	public String toString() {
		return String.format("RoleModel[id=%s, name=%s]", super.getId(), super.getName());
	}

}
