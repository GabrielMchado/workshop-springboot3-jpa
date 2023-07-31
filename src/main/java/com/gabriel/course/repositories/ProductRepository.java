package com.gabriel.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.course.entities.Products;

public interface ProductRepository extends JpaRepository<Products, Long>{	

	
}
