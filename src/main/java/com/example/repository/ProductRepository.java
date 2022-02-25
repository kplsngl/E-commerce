package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.entity.product.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {

	List<Product> findByName(String name);
	Optional<Product> findById(String id);

    List<Object> findByCategory(String catg);
}
