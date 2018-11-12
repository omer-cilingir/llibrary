package com.call.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.call.application.domain.Comment;
import com.call.application.repository.CommentRepository;
import com.call.application.service.base.CommentService;
import com.call.application.service.model.CommentModel;

@Service
@Transactional(readOnly=true)
public class SimpleCommentService extends SimpleCrudService<Comment, CommentModel> implements CommentService{

	@Autowired
	public SimpleCommentService(CommentRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

}
