package com.library.project.controller;

import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.project.model.User;
import com.library.project.repository.UserRepository;
import com.library.project.util.DateUtil;
import com.library.project.util.RandomUtil;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JavaMailSender javaMailSender;

	@GetMapping(path = "/all")
	public List<User> getAllUsers() {
		List<User> userList = userRepository.findAll();
		return userList;
	}

	@PostMapping(path = "/addUser", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<?> addUser(@Valid @RequestBody User user) {

		HttpHeaders textPlainHeaders = new HttpHeaders();
		textPlainHeaders.setContentType(MediaType.TEXT_PLAIN);

		User existUsername = userRepository.findByUsername(user.getUsername());
		if (existUsername != null)
			return new ResponseEntity<>("Username already exists", textPlainHeaders, HttpStatus.BAD_REQUEST);
		User existEmail = userRepository.findByEmail(user.getEmail());
		if (existEmail != null)
			return new ResponseEntity<>("Email already exists", textPlainHeaders, HttpStatus.BAD_REQUEST);

		User userModel = new User();
		userModel.setCreatedDate(DateUtil.now());
		userModel.setLastModifiedDate(DateUtil.now());
		userModel.setUsername(user.getUsername());
		userModel.setEmail(user.getEmail());
		userModel.setActivationKey(RandomUtil.generateActivationKey());
		userModel.setActivate(false);
		userModel.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(userModel);

		try {
			sendEmail(userModel);
		} catch (Exception e) {
			return new ResponseEntity<>("Error in sending mail", textPlainHeaders, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	private void sendEmail(User userModel) throws Exception {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		String link = "<a href=\"http://localhost:8080/api/user/active/\">CLICK HERE TO ACTIVATE YOUR ACCOUNT</a>";
		helper.setTo(userModel.getEmail());
		helper.setText("Your Activation Code Is : " + userModel.getActivationKey() + "<br>" + link,true);
		helper.setSubject("HELLO " + userModel.getUsername());

		javaMailSender.send(message);
	}

	@PostMapping(path = "/updateUser", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<?> updateUser(@Valid @RequestBody User user) {

		HttpHeaders textPlainHeaders = new HttpHeaders();
		textPlainHeaders.setContentType(MediaType.TEXT_PLAIN);

		User existUsername = userRepository.findByUsername(user.getUsername());
		if (existUsername != null) {
			existUsername.setLastModifiedDate(DateUtil.now());
			existUsername.setUsername(user.getUsername());
			existUsername.setEmail(user.getEmail());
			existUsername.setActivationKey(existUsername.getActivationKey());
			existUsername.setActivate(existUsername.isActivate());
			existUsername.setPassword(existUsername.getPassword());
			existUsername.setActivate(true);
			userRepository.save(existUsername);

			return new ResponseEntity<>(HttpStatus.CREATED);
		} else
			return new ResponseEntity<>("USERNAME NOT FOUND", textPlainHeaders, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping(path = "delete/{username}")
	public ResponseEntity<?> deleteUser(@PathVariable String username) {
		HttpHeaders textPlainHeaders = new HttpHeaders();
		textPlainHeaders.setContentType(MediaType.TEXT_PLAIN);

		User existUsername = userRepository.findByUsername(username);
		if (existUsername != null) {
			userRepository.delete(existUsername);

			return new ResponseEntity<>(HttpStatus.CREATED);
		} else
			return new ResponseEntity<>("USERNAME NOT FOUND", textPlainHeaders, HttpStatus.BAD_REQUEST);
	}

	@GetMapping(path = "/findUser/{username}")
	public User findUser(@PathVariable String username) {
		User existUsername = userRepository.findByUsername(username);
		return existUsername;
	}
	
	@GetMapping(path = "/active/{activationKey}")
	public ResponseEntity<?> activate(@PathVariable String activationKey) {
		
		HttpHeaders textPlainHeaders = new HttpHeaders();
		textPlainHeaders.setContentType(MediaType.TEXT_PLAIN);
		
		User existUser = userRepository.findByActivationKey(activationKey);
		if (existUser != null) {
			existUser.setActivate(true);
			existUser.setActivationKey(null);
			existUser.setLastModifiedDate(DateUtil.now());
			userRepository.save(existUser);
			
			return new ResponseEntity<>("CONGRATULATIONS! YOU CAN USE APP NOW", textPlainHeaders, HttpStatus.OK);
		}
		return new ResponseEntity<>("USER NOT FOUND!", textPlainHeaders, HttpStatus.BAD_REQUEST);
	}
}
