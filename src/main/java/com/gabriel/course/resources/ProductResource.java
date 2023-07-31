package com.gabriel.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.course.entities.Products;
import com.gabriel.course.service.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public 	ResponseEntity<List<Products>> findAll(){
		List<Products> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Products> fidById(@PathVariable Long id){
		Products product = service.findById(id);
		return ResponseEntity.ok().body(product);
	}
	
}
