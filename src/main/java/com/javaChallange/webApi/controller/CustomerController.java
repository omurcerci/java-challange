package com.javaChallange.webApi.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaChallange.business.abstracts.CustomerService;
import com.javaChallange.entities.concretes.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/getAll")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping("/getById/{customerId}")
	public Customer getCustomerById(@PathVariable UUID customerId) {
		return customerService.getCustomerById(customerId);
	}

	@PostMapping("/create")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}

	@PutMapping("/updateCustomer/{customerId}")
	public Customer updateCustomer(@PathVariable UUID customerId, @RequestBody Customer updatedCustomer) {
		return customerService.updateCustomer(customerId, updatedCustomer);
	}

	@DeleteMapping("/deleteCustomer/{customerId}")
	public void deleteCustomer(@PathVariable UUID customerId) {
		customerService.deleteCustomer(customerId);
	}
}
