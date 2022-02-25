package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.customer.Customer;
import com.example.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer getCustomerById(String id) {
		return customerRepository.findById(id).get();
	}

	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

}
