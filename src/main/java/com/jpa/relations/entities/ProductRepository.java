package com.jpa.relations.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.relations.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
