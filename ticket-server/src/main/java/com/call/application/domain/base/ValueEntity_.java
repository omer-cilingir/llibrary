package com.call.application.domain.base;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ValueEntity.class)
public class ValueEntity_ extends BaseEntity_ {
	public static volatile SingularAttribute<ValueEntity, String> code;
	public static volatile SingularAttribute<ValueEntity, String> value;
}
