package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.entity.customer.Customer;
import com.example.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin
public class CustomerController {

	@Autowired
	CustomerService customerService;


	@PostMapping("/signup")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}

	@GetMapping("/getById/{id}")
	public Customer getCustomerById(@PathVariable String id) {
		return customerService.getCustomerById(id);
	}
	
	@GetMapping("/login")
	public Boolean login(@RequestParam String id, @RequestParam String password) {
		if(customerService.getCustomerById(id).getPassword().equals(password))
			return true;
		else
			return false;
	}

	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}

	
}
