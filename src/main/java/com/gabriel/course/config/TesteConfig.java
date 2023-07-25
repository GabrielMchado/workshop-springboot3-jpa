package com.gabriel.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gabriel.course.entities.User;
import com.gabriel.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Maria Silva", "maria@yahoo.com", "1199997778", "abc");
		User user2 = new User(null, "Jose Almeida", "jose@hotmail.com", "3198877667", "1234");
		
		userRepository.saveAll(Arrays.asList(user1, user2));
	}
	
}
