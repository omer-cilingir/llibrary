package com.call.application.domain.base;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(BaseEntity.class)
public class BaseEntity_ {

	public static volatile SingularAttribute<BaseEntity, Long> id;
	public static volatile SingularAttribute<BaseEntity, Integer> version;
	public static volatile SingularAttribute<BaseEntity, String> name;
	public static volatile SingularAttribute<BaseEntity, String> createdBy;
	public static volatile SingularAttribute<BaseEntity, Date> createdDate;
	public static volatile SingularAttribute<BaseEntity, String> lastModifiedBy;
	public static volatile SingularAttribute<BaseEntity, Date> lastModifiedDate;
	public static volatile SingularAttribute<BaseEntity, Boolean> deleted;
	public static volatile SingularAttribute<BaseEntity, Date> deletedDate;
	public static volatile SingularAttribute<BaseEntity, Date> restoredDate;
	
}