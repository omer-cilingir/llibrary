package com.call.application.service.base;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.call.application.domain.User;
import com.call.application.service.model.UserDTO;
import com.call.application.service.model.UserModel;

public interface UserService extends CrudService<User, UserModel> {
	
	UserModel findByUsername(String username);
	
	List<UserModel> findByRoleId(Long roleId);
	
	UserModel getCurrentUser();

	User getUserWithAuthorities();

	Optional<User> getUserWithAuthoritiesByUsername(String username);

	Page<UserDTO> getAllManagedUsers(Pageable pageable);

	void changePassword(String password);

	void deleteUser(String username);

	Optional<UserDTO> updateUser(UserDTO userDTO);

	void updateUser(String firstname, String lastname, String email, String langKey);

	User createUser(UserDTO userDTO);

	User createUser(String username, String password, String firstname, String lastname, String email, String imageUrl,
			String langKey);

	Optional<User> requestPasswordReset(String mail);

	Optional<User> completePasswordReset(String newPassword, String key);

	Optional<User> activateRegistration(String key);
}
