package com.tomoaki3284.BasicRestApi.service;

import com.tomoaki3284.BasicRestApi.model.User;
import com.tomoaki3284.BasicRestApi.model.UserDTO;
import com.tomoaki3284.BasicRestApi.repository.UserRepository;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User getRawUserById(Long uid) {
		User user = userRepository.findById(uid).orElse(null);
		
		if (user == null) {
			logger.info("user not found by id: " + uid);
			throw new RuntimeException("user not found by id: " + uid);
		}
		
		return user;
	}
	
	public UserDTO getUserById(Long uid) {
		User user = getRawUserById(uid);
		return new UserDTO(user);
	}
	
	public List<UserDTO> getAllUsers() {
		return userRepository
			.findAll()
			.stream()
			.map(UserDTO::new)
			.collect(Collectors.toUnmodifiableList());
	}
	
	public void createUser(String username) {
		User newUser = new User(username, "1234", "asdfghj", new Date());
		userRepository.save(newUser);
	}
	
	public void updateUser(Long uid, String newUsername) {
		User user = getRawUserById(uid);
		user.setUsername(newUsername);
		userRepository.save(user);
	}
}
