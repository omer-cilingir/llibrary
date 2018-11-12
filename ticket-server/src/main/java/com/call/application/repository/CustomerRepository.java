package com.call.application.repository;

import org.springframework.stereotype.Repository;

import com.call.application.domain.Customer;
import com.call.application.repository.base.BaseRepository;

@Repository
public interface CustomerRepository extends BaseRepository<Customer>{

}
