package com.gabriel.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gabriel.course.entities.Order;
import com.gabriel.course.entities.User;
import com.gabriel.course.repositories.OrderRepository;
import com.gabriel.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Maria Silva", "maria@yahoo.com", "1199997778", "abc");
		User user2 = new User(null, "Jose Almeida", "jose@hotmail.com", "3198877667", "1234");
		
		Order o1 = new Order(null, Instant.parse("2023-06-20T19:53:07Z"), user1);
		Order o2 = new Order(null, Instant.parse("2023-07-21T03:42:10Z"), user2);
		Order o3 = new Order(null, Instant.parse("2023-07-22T15:21:22Z"), user1);
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
}
