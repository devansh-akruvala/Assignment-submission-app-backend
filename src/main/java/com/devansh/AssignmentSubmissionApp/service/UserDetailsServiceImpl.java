package com.devansh.AssignmentSubmissionApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.devansh.AssignmentSubmissionApp.model.User;
import com.devansh.AssignmentSubmissionApp.repository.UserRepository;


public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> userOpt = userRepository.findByUsername(username);
		
		return userOpt.orElseThrow(()->new UsernameNotFoundException("Invalid Credemtial"));
	}

}
