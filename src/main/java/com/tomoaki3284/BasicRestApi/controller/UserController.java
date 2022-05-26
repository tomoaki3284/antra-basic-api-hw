package com.tomoaki3284.BasicRestApi.controller;

import com.tomoaki3284.BasicRestApi.model.UserDTO;
import com.tomoaki3284.BasicRestApi.service.UserService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
		return new ResponseEntity<>(
			userService.getUserById(id),
			HttpStatus.OK
		);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		List<UserDTO> userDTOS = userService.getAllUsers();
		
		return new ResponseEntity<>(
			userDTOS,
			HttpStatus.OK
		);
	}
	
	@PostMapping("/users/{username}")
	public ResponseEntity<?> createUser(@PathVariable String username) {
		userService.createUser(username);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@PatchMapping("/users/{uid}/{newUsername}")
	public ResponseEntity<?> updateUser(@PathVariable Long uid, @PathVariable String newUsername) {
		userService.updateUser(uid, newUsername);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@GetMapping("/exception")
	public ResponseEntity<UserDTO> testException() throws Exception{
		throw new Exception("Global Exception Handler Check");
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity handleRuntimeException() {
		return new ResponseEntity("something went wrong", HttpStatus.NOT_FOUND);
	}
}
