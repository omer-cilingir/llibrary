package com.library.project.service.base;

import java.util.List;

import com.library.project.model.User;

public interface UserService {

	User addUser(User user);
	
	List<User> getAllUsers();
	
	User updateUser(User user, User existUsername);
	
	void deleteUser(User user);
	
	User findUser(String username);
	
	void activate(User user);
}
