package com.call.application.web.rest;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.call.application.domain.base.BaseEntity;
import com.call.application.service.base.CrudService;
import com.call.application.service.model.base.BaseModel;
import com.call.application.web.rest.base.CrudController;



public abstract class SimpleCrudController<E extends BaseEntity, M extends BaseModel> implements CrudController<E, M> {

	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleCrudController.class);

	private final CrudService<E, M> service;
	private final Class<E> entityClass;
	private final String entityClassName;

	@SuppressWarnings("unchecked")
	public SimpleCrudController(CrudService<E, M> service) {
		this.service = service;
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
		this.entityClassName = this.entityClass.getSimpleName();
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	@Override
	public M create(@RequestBody @Valid M model) throws MethodArgumentNotValidException {
		LOGGER.info("Creating a new {} data with information: {}", this.entityClassName, model);

		M created = service.create(model);

		LOGGER.info("Created a new {} data with information: {}", this.entityClassName, created);

		return created;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@Override
	public M delete(@PathVariable("id") Long id) {
		LOGGER.info("Deleting {} data with id: {}", this.entityClassName, id);

		M deleted = service.delete(id);

		LOGGER.info("Deleted {} data with information: {}", this.entityClassName, deleted);

		return deleted;
	}

	@RequestMapping(method = RequestMethod.GET)
	@Override
	public List<M> findAll() {
		LOGGER.info("Finding all {} datas", this.entityClassName);

		List<M> models = service.findAll();

		LOGGER.info("Found {} {} datas", models.size(), this.entityClassName);

		return models;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@Override
	public M findById(@PathVariable("id") Long id) {
		LOGGER.info("Finding {} data with id: {}", this.entityClassName, id);

		M model = service.findById(id);

		LOGGER.info("Found {} data with information: {}", this.entityClassName, model);

		return model;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PATCH)
	@Override
	public M update(@PathVariable("id") Long id, @RequestBody Map<String, Object> updateValues) {
		LOGGER.info("Updating {} {} data with information: {}", this.entityClassName, id, updateValues);

		M updated = service.update(id, updateValues);

		LOGGER.info("Updated {} data with information: {}", this.entityClassName, updated);

		return updated;
	}

}
