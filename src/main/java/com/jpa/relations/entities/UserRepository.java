package com.jpa.relations.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.relations.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
