package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.orders.Orders;

@Repository
public interface OrdersRepository extends MongoRepository<Orders,String> {

}
