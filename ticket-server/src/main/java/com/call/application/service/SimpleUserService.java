package com.call.application.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.call.application.config.Constants;
import com.call.application.domain.Role;
import com.call.application.domain.User;
import com.call.application.enums.UserType;
import com.call.application.exception.EntityNotFoundException;
import com.call.application.repository.RoleRepository;
import com.call.application.repository.UserRepository;
import com.call.application.security.RoleConstants;
import com.call.application.security.SecurityUtils;
import com.call.application.service.base.UserService;
import com.call.application.service.model.UserDTO;
import com.call.application.service.model.UserModel;
import com.call.application.service.util.DateHelper;
import com.call.application.service.util.RandomUtil;

@Transactional(readOnly = true)
@Service
public class SimpleUserService extends SimpleCrudService<User, UserModel> implements UserService {

	private final Logger log = LoggerFactory.getLogger(SimpleUserService.class);

	private final UserRepository repository;

	private final RoleRepository roleRepository;

	private final PasswordEncoder passwordEncoder;
	
	public SimpleUserService(UserRepository repository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
		super(repository);
		this.repository = repository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserModel findByUsername(String username) {
		String lowercaseUsername = username.toLowerCase(Locale.ENGLISH);
		log.info("Finding user data with username: {}", lowercaseUsername);

		User found = this.repository.findOneByUsername(lowercaseUsername)
				.orElseThrow(() -> new EntityNotFoundException(User.class.getSimpleName(), "username", lowercaseUsername));

		log.info("Found user data: {}", found);

		return this.convert(found);
	}

	@Override
	public List<UserModel> findByRoleId(Long roleId) {

		log.info("Finding users data with role id: {}", roleId);

		List<User> founds = this.findUsersByRoleId(roleId);

		log.info("Found users data: {}", founds);

		return this.convertAll(founds);
	}

	private List<User> findUsersByRoleId(Long roleId) {
		List<User> users = this.repository.findByRolesId(roleId);
		if (users == Collections.EMPTY_LIST)
			throw new EntityNotFoundException(User.class.getSimpleName(), "roleId", roleId.toString());
		return users;
	}

	@Override
	public UserModel getCurrentUser() {
		
		log.info("Getting current user data");
		
		User currentUser = this.repository.findOneByUsername(SecurityUtils.getCurrentUsername()).orElse(null);

		log.info("Found current user data: {}", currentUser);
		
		return this.convert(currentUser);
		
	}

	@Transactional
	@Override
    public Optional<User> activateRegistration(String key) {
        log.debug("Activating user for activation key {}", key);
        return repository.findOneByActivationKey(key)
            .map(user -> {
                // activate given user for the registration key.
                user.setActivated(true);
                user.setActivationKey(null);
                log.debug("Activated user: {}", user);
                return user;
            });
    }

	@Transactional
	@Override
    public Optional<User> completePasswordReset(String newPassword, String key) {
       log.debug("Reset user password for reset key {}", key);

       return repository.findOneByResetKey(key)
            .filter(user -> {
                return user.getResetDate().after(DateHelper.yesterday());
           })
           .map(user -> {
                user.setPassword(passwordEncoder.encode(newPassword));
                user.setResetKey(null);
                user.setResetDate(null);
                return user;
           });
    }

	@Transactional
	@Override
    public Optional<User> requestPasswordReset(String mail) {
        return repository.findOneByEmail(mail)
            .filter(User::isActivated)
            .map(user -> {
                user.setResetKey(RandomUtil.generateResetKey());
                user.setResetDate(DateHelper.now());
                return user;
            });
    }

	@Transactional
	@Override
   public User createUser(String username, String password, String firstname, String lastname, String email,
        String imageurl, String langkey) {

        User newUser = new User();
        Role role = roleRepository.findByCode(RoleConstants.ANONYMOUS);
        Set<Role> roles = new HashSet<>();
        String encryptedPassword = passwordEncoder.encode(password);
        newUser.setUsername(username);
        // new user gets initially a generated password
        newUser.setPassword(encryptedPassword);
        newUser.setFirstname(firstname);
        newUser.setLastname(lastname);
        newUser.setEmail(email);
        newUser.setImageUrl(imageurl);
        newUser.setLangKey(langkey);
        newUser.setUserType(UserType.EMPTY);
        // new user is not active
        newUser.setActivated(false);
        // new user gets registration key
        newUser.setActivationKey(RandomUtil.generateActivationKey());
        
        roles.add(role);
        newUser.setRoles(roles);
        repository.save(newUser);
        log.debug("Created Information for User: {}", newUser);
        return newUser;
    }

	@Transactional
	@Override
    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setEmail(userDTO.getEmail());
        user.setImageUrl(userDTO.getImageUrl());
        if (userDTO.getLangKey() == null) {
            user.setLangKey("en"); // default language
        } else {
            user.setLangKey(userDTO.getLangKey());
        }
        if (userDTO.getRoles() != null) {
            Set<Role> roles = new HashSet<>();
            userDTO.getRoles().forEach(
                role -> roles.add(roleRepository.findByCode(role))
            );
            user.setRoles(roles);
        }
        String encryptedPassword = passwordEncoder.encode(RandomUtil.generatePassword());
        user.setPassword(encryptedPassword);
        user.setResetKey(RandomUtil.generateResetKey());
        user.setResetDate(DateHelper.now());
        user.setActivated(true);
        repository.save(user);
        log.debug("Created Information for User: {}", user);
        return user;
    }

    /**
     * Update basic information (first name, last name, email, language) for the current user.
     */
	@Transactional
	@Override
    public void updateUser(String firstname, String lastname, String email, String langKey) {
        repository.findOneByUsername(SecurityUtils.getCurrentUsername()).ifPresent(user -> {
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setEmail(email);
            user.setLangKey(langKey);
            log.debug("Changed Information for User: {}", user);
        });
	}
	
    /**
     * Update all information for a specific user, and return the modified user.
     */
	@Transactional
	@Override
    public Optional<UserDTO> updateUser(UserDTO userDTO) {
        return Optional.of(repository
            .findOne(userDTO.getId()))
            .map(user -> {
                user.setUsername(userDTO.getUsername());
                user.setFirstname(userDTO.getFirstname());
                user.setLastname(userDTO.getLastname());
                user.setEmail(userDTO.getEmail());
                user.setImageUrl(userDTO.getImageUrl());
                user.setActivated(userDTO.isActivated());
                user.setLangKey(userDTO.getLangKey());
                Set<Role> managedRoles = user.getRoles();
                managedRoles.clear();
                userDTO.getRoles().stream()
                    .map(roleRepository::findByCode)
                    .forEach(managedRoles::add);
                log.debug("Changed Information for User: {}", user);
                return user;
            })
            .map(UserDTO::new);
    }

	@Transactional
	@Override
    public void deleteUser(String username) {
        repository.findOneByUsername(username).ifPresent(user -> {
            repository.softDelete(user);
            log.debug("Deleted User: {}", user);
        });
    }

	@Transactional
	@Override
    public void changePassword(String password) {
        repository.findOneByUsername(SecurityUtils.getCurrentUsername()).ifPresent(user -> {
            String encryptedPassword = passwordEncoder.encode(password);
            user.setPassword(encryptedPassword);
            log.debug("Changed password for User: {}", user);
        });
    }

	@Override
    public Page<UserDTO> getAllManagedUsers(Pageable pageable) {
        return repository.findAllByUsernameNot(pageable, Constants.ANONYMOUS_USER).map(UserDTO::new);
    }

	@Override
    public Optional<User> getUserWithAuthoritiesByUsername(String username) {
        return repository.findOneByUsername(username);
    }

	@Override
    public User getUserWithAuthorities() {
        return repository.findOneByUsername(SecurityUtils.getCurrentUsername()).orElse(null);
    }

    /**
     * Not activated users should be automatically deleted after 3 days.
     * <p>
     * This is scheduled to get fired everyday, at 01:00 (am).
     * </p>
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void removeNotActivatedUsers() {
        List<User> users = repository.findAllByActivatedIsFalseAndCreatedDateBefore(DateHelper.minusDays(3));
        for (User user : users) {
            log.debug("Deleting not activated user {}", user.getUsername());
            repository.softDelete(user);
        }
    }
}
