package com.call.application.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.call.application.domain.User;
import com.call.application.repository.base.BaseRepository;

@Repository
public interface UserRepository extends BaseRepository<User> {
        
    public List<User> findByRolesId(Long roleId);
    
    public Optional<User> findOneByActivationKey(String activationKey);

    public List<User> findAllByActivatedIsFalseAndCreatedDateBefore(Date date);

    public Optional<User> findOneByResetKey(String resetKey);

    public Optional<User> findOneByEmail(String email);

    public Optional<User> findOneByUsername(String username);

    public Page<User> findAllByUsernameNot(Pageable pageable, String username);
    
}
