package com.call.application.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.call.application.domain.Authority;
import com.call.application.domain.Role;
import com.call.application.repository.base.BaseRepository;

@Repository
public interface RoleRepository extends BaseRepository<Role> {
	
	public Role findByCode(String code);
	
	public List<Role> findByAuthorities(Authority authority);
	
}
