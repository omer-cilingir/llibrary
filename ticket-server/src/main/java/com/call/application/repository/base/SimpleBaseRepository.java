package com.call.application.repository.base;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.call.application.domain.base.BaseEntity;
import com.call.application.repository.base.specification.BaseEntitySpecifications;

@Transactional(readOnly = true)
@SuppressWarnings("unchecked")
public class SimpleBaseRepository<E extends BaseEntity> extends SimpleJpaRepository<E, Long> implements BaseRepository<E> {

	private final EntityManager entityManager;
	private final JpaEntityInformation<E, Long> entityInformation;
	
	public SimpleBaseRepository(JpaEntityInformation<E, Long> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
		this.entityInformation = entityInformation;
	}

	@Override
	public void refresh(E entity) {
		this.entityManager.refresh(entity);
	}
	
	@Override
	public E findOne(Long id){
		return super.findOne((Specification<E>) BaseEntitySpecifications.filterByIdAndDeleted(id, false));
	}
	
	@Override
	public List<E> findAll() {
		return super.findAll((Specification<E>) BaseEntitySpecifications.deletedEquals(false), new Sort(Direction.ASC, "id"));
	}
	
	@Override
	public List<E> recycleBin() {
		return super.findAll((Specification<E>) BaseEntitySpecifications.deletedEquals(true), new Sort(Direction.ASC, "id"));
	}
	
	@Override
	@Transactional
	public E softDelete(Long id) {

		Assert.notNull(id, "The given id must not be null!");

		E entity = findOne(id);

		if (entity == null) {
			throw new EmptyResultDataAccessException(
					String.format("No %s entity with id %s exists!", entityInformation.getJavaType(), id), 1);
		}
		
		return softDelete(entity);
	}

	@Override
	@Transactional
	public E restoreDeleted(Long id) {

		Assert.notNull(id, "The given id must not be null!");
		
		E entity = findOne(id);

		if (entity == null) {
			throw new EmptyResultDataAccessException(
					String.format("No %s entity with id %s exists!", entityInformation.getJavaType(), id), 1);
		}

		return restoreDeleted(entity);
	}

	@Override
	@Transactional
	public E softDelete(E entity) {
		
		Assert.notNull(entity, "The entity must not be null!");
		
		entity.setDeletedDate(new Date());
		entity.setDeleted(true);

		return super.save(entity);
	}

	@Override
	@Transactional
	public E restoreDeleted(E entity) {
		
		Assert.notNull(entity, "The entity must not be null!");
		
		entity.setRestoredDate(new Date());
		entity.setDeleted(false);

		return super.save(entity);
	}

}
