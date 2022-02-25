package com.example.service;


import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

//import javax.swing.text.Document;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import com.example.entity.cart.Cart;
import com.example.repository.CartRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Filters;


@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;

	@Autowired
	MongoClient mongoClient;
	
	public Cart createCart(Cart cart) {
		return cartRepository.save(cart);
	}

	public List<Cart> getAllCart() {
		return cartRepository.findAll();
	}

	public String addCartItem(String id , String pId) {
		Document document = new Document("$push", new Document("product_ids", pId));
		Bson filter = Filters.eq("_id", id);
		mongoClient.getDatabase("eComm").getCollection("Cart", Cart.class).updateOne(filter, document);
		return "Item added to cart.";
	}

	public String removeItem(String id, String pId) {
		Document document = new Document("$pull", new Document("product_ids", pId));
		Bson filter = Filters.eq("_id", id);
		mongoClient.getDatabase("eComm").getCollection("Cart", Cart.class).updateOne(filter, document);
		return "Item Removed!";
	}
	public Cart getCartById(String id) {
		return cartRepository.findById(id).get();
	}
}
