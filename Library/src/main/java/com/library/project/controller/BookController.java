package com.library.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.project.model.BookModel;
import com.library.project.repository.BookRepository;
import com.library.project.util.DateUtil;

@RestController
@RequestMapping("/api/book")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/all")
	public List<BookModel> getBookList(){
		List<BookModel> bookList = bookRepository.findAll();
		return bookList;
	}
	
	 @PostMapping(path = "/addBook",
             produces={MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
	public BookModel addBook(@Valid @RequestBody BookModel book) {
		BookModel bookModel = new BookModel();
		bookModel.setBookName(book.getBookName());
		bookModel.setAuthorName(book.getAuthorName());
		bookModel.setAuthorSurname(book.getAuthorSurname());
		bookModel.setCreatedDate(DateUtil.now());
		bookModel.setLastModifiedDate(DateUtil.now());
		bookRepository.save(bookModel);
		return book;
	}
	 
	@GetMapping("/{bookName}") 
	private List<BookModel> getBookListByBookName(@PathVariable String bookName) {
		List<BookModel> bookList = bookRepository.findByBookName(bookName);
		return bookList;
	}

}
