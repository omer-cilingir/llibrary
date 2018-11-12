package com.call.application.web.rest.base;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;

import com.call.application.domain.base.BaseEntity;
import com.call.application.service.model.base.BaseModel;


public interface CrudController<E extends BaseEntity, M extends BaseModel> {
	
	M create(M model) throws MethodArgumentNotValidException;

	M delete(Long id);

	List<M> findAll();

	M findById(Long id);

	M update(Long id, Map<String, Object> updateValues);

}
