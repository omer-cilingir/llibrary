package com.call.application.repository.base.specification;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import com.call.application.domain.base.BaseEntity;
import com.call.application.domain.base.BaseEntity_;
import com.call.application.service.util.DateHelper;

public class BaseEntitySpecifications {
	
	public static Specification<BaseEntity> idEquals(Long id) {
		return new Specification<BaseEntity>() {
			public Predicate toPredicate(Root<BaseEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.equal(root.get(BaseEntity_.id), id);
			}
		};
	}
	
	public static Specification<BaseEntity> createdDateEquals(Date date) {
		return new Specification<BaseEntity>() {
			public Predicate toPredicate(Root<BaseEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

				Date startOfDate = DateHelper.startOfDay(date);
				Date endOfDate = DateHelper.endOfDay(date);
				
				return builder.between(root.get(BaseEntity_.createdDate), startOfDate, endOfDate);
			}
		};
	}
	
	public static Specification<BaseEntity> deletedEquals(boolean deleted) {
		return new Specification<BaseEntity>() {
			public Predicate toPredicate(Root<BaseEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) {				
				return builder.equal(root.get(BaseEntity_.deleted), deleted);
			}
		};
	}
	
	public static Specification<BaseEntity> filterByIdAndDeleted(Long id, boolean deleted){
		return Specifications.where(idEquals(id)).and(deletedEquals(deleted));
	}
	
}
