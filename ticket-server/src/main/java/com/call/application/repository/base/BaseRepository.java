package com.call.application.repository.base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.call.application.domain.base.BaseEntity;

@NoRepositoryBean
public interface BaseRepository<E extends BaseEntity> extends JpaRepository<E, Long>, JpaSpecificationExecutor<E> { // RevisionRepository<E, Long, Integer>,
	public void refresh(E entity);
	public List<E> recycleBin();
	public E softDelete(Long id);
	public E softDelete(E entity);
	public E restoreDeleted(Long id);
	public E restoreDeleted(E entity);
}
