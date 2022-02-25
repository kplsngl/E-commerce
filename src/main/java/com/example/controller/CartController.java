package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.entity.cart.Cart;


@RestController
@RequestMapping("/api/cart")
@CrossOrigin
public class CartController {

	@Autowired
	com.example.service.CartService cartService;
	
	@PostMapping("/create")
	public Cart createCart(@RequestBody Cart cart) {
		return cartService.createCart(cart);
	}
	
	@GetMapping("/getById")
	public Cart getCartById(@RequestParam String id) {
		return cartService.getCartById(id);
	}
	
	@PutMapping("/addCartItem")
	public String addCartItem(@RequestParam String id, @RequestParam String pId) {
		return cartService.addCartItem(id,pId);
	}
	@DeleteMapping("/removeItem")
	public String removeItem(@RequestParam String id, @RequestParam String pId) {
		return cartService.removeItem(id,pId);
	}

}
