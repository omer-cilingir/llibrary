package com.call.application.service;

import org.springframework.transaction.annotation.Transactional;

import com.call.application.domain.Category;
import com.call.application.repository.CategoryRepository;
import com.call.application.service.base.CategoryService;
import com.call.application.service.model.CategoryModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional(readOnly = true)
@Service
public class SimpleCategoryService extends SimpleCrudService<Category, CategoryModel> implements CategoryService{
	
	@Autowired
	public SimpleCategoryService(CategoryRepository categoryRepository) {
		super(categoryRepository);
	}

}
