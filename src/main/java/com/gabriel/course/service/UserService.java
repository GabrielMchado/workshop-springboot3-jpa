package com.gabriel.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.course.entities.User;
import com.gabriel.course.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}

	public User findById(Long id) {
		Optional<User> opt = userRepository.findById(id);
		return opt.get();
	}
	
}
