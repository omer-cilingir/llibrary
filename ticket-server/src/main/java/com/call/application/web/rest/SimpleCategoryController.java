package com.call.application.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.call.application.domain.Category;
import com.call.application.service.base.CategoryService;
import com.call.application.service.model.CategoryModel;
import com.call.application.web.rest.base.CategoryController;

@RequestMapping("/api/categories")
@RestController
public class SimpleCategoryController extends SimpleCrudController<Category, CategoryModel> implements CategoryController{
	@Autowired
	public SimpleCategoryController(CategoryService service) {
		super(service);

	}
}
