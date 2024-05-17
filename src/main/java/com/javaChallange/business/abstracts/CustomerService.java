package com.javaChallange.business.abstracts;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.javaChallange.entities.concretes.Customer;

@Service
@Repository
public interface CustomerService {

	public List<Customer> getAllCustomers();

	public Customer getCustomerById(UUID customerId);

	public Customer createCustomer(Customer customer);

	public Customer updateCustomer(UUID customerId, Customer updatedCustomer);

	public void deleteCustomer(UUID customerId);
}
