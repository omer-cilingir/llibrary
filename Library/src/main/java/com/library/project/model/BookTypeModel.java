package com.library.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.library.project.model.base.BaseModel;

@Entity
@Table(name = "BOOK_TYPE")
public class BookTypeModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	@Size(max = 40)
	private String typeName;

	@OneToMany
	private List<BookModel> bookList = new ArrayList<BookModel>();

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<BookModel> getBookList() {
		return bookList;
	}

	public void setBookList(List<BookModel> bookList) {
		this.bookList = bookList;
	}

}
