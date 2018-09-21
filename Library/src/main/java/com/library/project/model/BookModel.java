package com.library.project.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.library.project.model.base.BaseModel;

@Entity
@Table(name = "BOOK")
public class BookModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	@Size(max = 50)
	private String bookName;

	@Size(max = 50)
	private String authorName;

	@Size(max = 50)
	private String authorSurname;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorSurname() {
		return authorSurname;
	}

	public void setAuthorSurname(String authorSurname) {
		this.authorSurname = authorSurname;
	}

}
