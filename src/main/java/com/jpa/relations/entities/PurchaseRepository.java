package com.jpa.relations.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.relations.entities.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
	
}
