package com.call.application.repository;

import org.springframework.stereotype.Repository;

import com.call.application.domain.Authority;
import com.call.application.repository.base.BaseRepository;

@Repository
public interface AuthorityRepository extends BaseRepository<Authority> {
	
}
