package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.cart.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart,String> {
	
	

}
