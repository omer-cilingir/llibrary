package com.library.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.project.model.BookTypeModel;

@Repository
public interface BookTypeRepository extends JpaRepository<BookTypeModel, Long>{

}
