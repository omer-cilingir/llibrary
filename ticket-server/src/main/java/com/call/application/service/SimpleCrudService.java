package com.call.application.service;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;


import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.call.application.domain.base.BaseEntity;
import com.call.application.exception.EntityNotFoundException;
import com.call.application.repository.base.BaseRepository;
import com.call.application.service.base.CrudService;
import com.call.application.service.model.base.BaseModel;
import com.call.application.service.util.ModelMapperHelper;

@Transactional(readOnly = true)
@Service
public abstract class SimpleCrudService<E extends BaseEntity, M extends BaseModel> implements CrudService<E, M> {

	private final Logger LOGGER = LoggerFactory.getLogger(SimpleCrudService.class);
	private final ModelMapper MAPPER = new ModelMapper();

	private final BaseRepository<E> repository;
	private final Class<? extends E> entityClass;
	private final Class<? extends M> modelClass;
	private final String entityClassName;

	@SuppressWarnings("unchecked")
	public SimpleCrudService(BaseRepository<E> repository) {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
		this.modelClass = (Class<M>) genericSuperclass.getActualTypeArguments()[1];
		this.entityClassName = this.entityClass.getSimpleName();
		this.repository = repository;
		MAPPER.getConfiguration().setPropertyCondition(Conditions.isNotNull());
	}

	@CrossOrigin
	@Transactional
	@Override
	public M create(M model) throws MethodArgumentNotValidException {
		LOGGER.info("Creating a new {} data with information: {}", this.entityClassName, model);

		E persisted = this.convertBack(model);
		persisted = this.repository.save(persisted);

		LOGGER.info("Created a new {} data with information: {}", this.entityClassName, persisted);

		return this.convert(persisted);
	}

	@Transactional
	@Override
	public M delete(Long id) {
		LOGGER.info("Deleting a {} data with id {}", this.entityClassName, id.toString());

		E deleted = findEntityById(id);
		this.repository.softDelete(deleted);

		LOGGER.info("Deleted {} data with information: {}", this.entityClassName, deleted);

		return this.convert(deleted);
	}

	@Override
	public List<M> findAll() {
		LOGGER.info("Finding all {} datas.", this.entityClassName);

		List<E> entities = this.repository.findAll();

		LOGGER.info("Found {} {} datas", entities.size(), this.entityClassName);

		return this.convertAll(entities);
	}

	@Override
	public M findById(Long id) {
		LOGGER.info("Finding {} data with id: {}", this.entityClassName, id);

		E found = findEntityById(id);

		LOGGER.info("Found {} data: {}", this.entityClassName, found);

		return this.convert(found);
	}
	
	@Transactional
	@Override
	public M update(Long id, Map<String, Object> updateValues) {
		LOGGER.info("Updating {} {} data with information: {}", this.entityClassName, id, updateValues);

		E updated = findEntityById(id);
		MAPPER.map(updateValues, updated);
		updated = this.repository.save(updated);

		LOGGER.info("Updated {} data with information: {}", this.entityClassName, updated);

		return this.convert(updated);
	}

	protected E findEntityById(Long id) {
		this.repository.flush();
		E entity = this.repository.findOne(id);
		if (entity == null)
			throw new EntityNotFoundException(this.entityClassName, "id", id.toString());
		return entity;
	}
	
	protected M convert(E entity) {
		return ModelMapperHelper.convert(entity, this.modelClass);
	}
	
	protected E convertBack(M model) {
		return ModelMapperHelper.convertBack(model, this.entityClass);
	}

	protected List<M> convertAll(List<E> entities) {
		return ModelMapperHelper.convertAll(entities, this.modelClass);
	}

	protected List<E> convertAllBack(List<M> models) {
		return ModelMapperHelper.convertAllBack(models, this.entityClass);
	}

	
}
