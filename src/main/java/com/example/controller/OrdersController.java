package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.entity.orders.Orders;
import com.example.service.OrdersService;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrdersController {

	@Autowired
	OrdersService ordersService;
	
	@PostMapping("/create")
	public Orders createOrders(@RequestBody Orders orders) {
		return ordersService.createOrders(orders);
	}

	@GetMapping("/all")
	public List<Orders> getAllOrders() {
		return ordersService.getAllOrders();
	}

	@GetMapping("/placeOrder")
	public String placeOrder(@RequestParam String id, @RequestParam String pId) {
		return ordersService.placeOrder(id,pId);
	}
}
