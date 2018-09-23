package com.library.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.project.model.BookTypeModel;
import com.library.project.repository.BookTypeRepository;
import com.library.project.util.DateUtil;

@RestController
@RequestMapping("/api/bookType")
public class BookTypeController {

	@Autowired
	private BookTypeRepository bookTypeRepository;
	
	@PostMapping(path = "/addBookType", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public BookTypeModel addBookType(@Valid @RequestBody BookTypeModel bookType) {

		BookTypeModel bookTypeModel = new BookTypeModel();
		bookTypeModel.setCreatedDate(DateUtil.now());
		bookTypeModel.setLastModifiedDate(DateUtil.now());
		bookTypeModel.setTypeName(bookType.getTypeName());
		bookTypeRepository.save(bookTypeModel);
		return bookTypeModel;
	}
	
	@GetMapping(path = "/all")
	public List<BookTypeModel> getBookListByType(){
		List<BookTypeModel> bookTypeModelList = bookTypeRepository.findAll();
		return bookTypeModelList;
	}
}
