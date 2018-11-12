package com.call.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.call.application.domain.Authority;
import com.call.application.repository.AuthorityRepository;
import com.call.application.service.base.AuthorityService;
import com.call.application.service.model.AuthorityModel;


@Transactional(readOnly = true)
@Service
public class SimpleAuthorityService extends SimpleCrudService<Authority, AuthorityModel> implements AuthorityService {
	
	@Autowired
	public SimpleAuthorityService(AuthorityRepository authorityRepository){
		super(authorityRepository);
	}

}
