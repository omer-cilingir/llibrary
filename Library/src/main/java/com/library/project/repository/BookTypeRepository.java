package com.library.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.project.model.BookTypeModel;

@Repository
public interface BookTypeRepository extends JpaRepository<BookTypeModel, Long>{
	
	public List<BookTypeModel> findByTypeName(String typeName);
	
}
