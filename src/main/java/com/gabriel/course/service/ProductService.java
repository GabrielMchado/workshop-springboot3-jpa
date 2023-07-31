package com.gabriel.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.course.entities.Products;
import com.gabriel.course.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productsRepository;
	
	public List<Products> findAll(){
		return productsRepository.findAll();
	}

	public Products findById(Long id) {
		Optional<Products> opt = productsRepository.findById(id);
		return opt.get();
	}
	
}
