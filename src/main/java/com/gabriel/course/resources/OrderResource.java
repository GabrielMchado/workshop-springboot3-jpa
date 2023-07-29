package com.gabriel.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.course.entities.Order;
import com.gabriel.course.service.OrderService;

@RestController
@RequestMapping(value="/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	@GetMapping
	public 	ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> fidById(@PathVariable Long id){
		Order Order = service.findById(id);
		return ResponseEntity.ok().body(Order);
	}
	
}
