package com.call.application.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.call.application.domain.Request;
import com.call.application.repository.base.BaseRepository;

@Repository
public interface RequestRepository extends BaseRepository<Request>{
	
	public List<Request> findByCreatedBy(String createdBy);
	public List<Request> findByUserUsername(String username);
	
}
