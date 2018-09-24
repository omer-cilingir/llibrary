package com.library.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.project.model.BookModel;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long>{

	public BookModel findByBookName(String bookName);
}
