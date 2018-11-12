package com.call.application.service.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;

import com.call.application.domain.base.BaseEntity;
import com.call.application.service.model.base.BaseModel;

public class ModelMapperHelper {
	private static final ModelMapper MAPPER = new ModelMapper();

	public ModelMapperHelper() {
		MAPPER.getConfiguration().setPropertyCondition(Conditions.isNotNull());
	}

	public static <E extends BaseEntity, M extends BaseModel> M convert(E entity, Class<? extends M> modelClass) {
		return MAPPER.map(entity, modelClass);
	}

	public static <E extends BaseEntity, M extends BaseModel> E convertBack(M model, Class<? extends E> entityClass) {
		return MAPPER.map(model, entityClass);
	}
		
	public static <E extends BaseEntity, M extends BaseModel> List<M> convertAll(List<E> entities, Class<? extends M> modelClass) {
		return entities.stream().map(entity -> convert(entity, modelClass)).collect(Collectors.toList());
	}

	public static <E extends BaseEntity, M extends BaseModel> List<E> convertAllBack(List<M> models, Class<? extends E> entityClass) {
		return models.stream().map(model -> convertBack(model, entityClass)).collect(Collectors.toList());
	}
	
}
