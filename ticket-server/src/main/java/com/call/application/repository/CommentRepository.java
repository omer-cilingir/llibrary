package com.call.application.repository;

import org.springframework.stereotype.Repository;

import com.call.application.domain.Comment;
import com.call.application.repository.base.BaseRepository;

@Repository
public interface CommentRepository extends BaseRepository<Comment>{	
}
