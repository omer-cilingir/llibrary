package com.call.application.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.call.application.domain.Comment;
import com.call.application.service.base.CommentService;
import com.call.application.service.model.CommentModel;
import com.call.application.web.rest.base.CommentController;

@RestController
@RequestMapping("/api/comments")
public class SimpleCommentController extends SimpleCrudController<Comment, CommentModel> implements CommentController{

	@Autowired
	public SimpleCommentController(CommentService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

}
