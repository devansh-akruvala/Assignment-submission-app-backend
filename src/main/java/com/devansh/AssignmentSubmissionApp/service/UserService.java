package com.devansh.AssignmentSubmissionApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devansh.AssignmentSubmissionApp.model.User;
import com.devansh.AssignmentSubmissionApp.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
