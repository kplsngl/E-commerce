package com.example.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.customer.Customer;
@Repository
public interface CustomerRepository extends MongoRepository<Customer,String> {
	
	Optional<Customer> findById(String id);

	Customer findByIdAndPassword(String id, String password);

}
