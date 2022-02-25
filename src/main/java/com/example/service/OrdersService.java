package com.example.service;

import java.util.List;

import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.orders.Orders;
import com.example.repository.OrdersRepository;

@Service
public class OrdersService {

	@Autowired
	OrdersRepository ordersRepository;

	@Autowired
	MongoClient mongoClient;
	
	public Orders createOrders(Orders Orders) {
		return ordersRepository.save(Orders);
	}

	public List<Orders> getAllOrders() {
		return ordersRepository.findAll();
	}

	public String placeOrder(String id , String pId) {
		Document document = new Document("$push", new Document("product_ids", pId));
		Bson filter = Filters.eq("_id", id);
		mongoClient.getDatabase("eComm").getCollection("Orders", Orders.class).updateOne(filter, document);
		return "Order Placed";
	}

}
