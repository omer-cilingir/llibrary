package com.call.application.service;

import java.util.Map;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.call.application.domain.base.BaseEntity;
import com.call.application.repository.base.BaseRepository;
import com.call.application.service.base.CrudService;
import com.call.application.service.model.base.BaseModel;


public abstract class SimpleReadOnlyService<E extends BaseEntity, M extends BaseModel> extends SimpleCrudService<E, M> implements CrudService<E, M> {

	public SimpleReadOnlyService(BaseRepository<E> repository) {
		super(repository);
	}

	@Override
	public M create(M model) throws MethodArgumentNotValidException {
		throw new NotImplementedException("Not allowed");
	}

	@Override
	public M update(Long id, Map<String, Object> updateValues) {
		throw new NotImplementedException("Not allowed");
	}

	@Override
	public M delete(Long id) {
		throw new NotImplementedException("Not allowed");
	}
	
}
