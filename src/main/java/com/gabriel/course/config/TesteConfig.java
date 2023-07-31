package com.gabriel.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gabriel.course.entities.Category;
import com.gabriel.course.entities.Order;
import com.gabriel.course.entities.Products;
import com.gabriel.course.entities.User;
import com.gabriel.course.entities.enums.OrderStatus;
import com.gabriel.course.repositories.CategoryRepository;
import com.gabriel.course.repositories.OrderRepository;
import com.gabriel.course.repositories.ProductRepository;
import com.gabriel.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category c1 = new Category(null, "Books");
		Category c2 = new Category(null, "Eletronics");
		Category c3 = new Category(null, "Shoes");
		
		Products p1 = new Products(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Products p2 = new Products(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Products p3 = new Products(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Products p4 = new Products(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Products p5 = new Products(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		User user1 = new User(null, "Maria Silva", "maria@yahoo.com", "1199997778", "abc");
		User user2 = new User(null, "Jose Almeida", "jose@hotmail.com", "3198877667", "1234");
		
		Order o1 = new Order(null, Instant.parse("2023-06-20T19:53:07Z"), OrderStatus.PAID, user1);
		Order o2 = new Order(null, Instant.parse("2023-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
		Order o3 = new Order(null, Instant.parse("2023-07-22T15:21:22Z"), OrderStatus.DELIVERED, user1);
		
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
}
