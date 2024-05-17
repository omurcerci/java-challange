package com.javaChallange.business.concretes;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaChallange.business.abstracts.CustomerService;
import com.javaChallange.dataAccess.abstracts.CustomerRepository;
import com.javaChallange.entities.concretes.Customer;

@Service
public class CustomerManager implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(UUID customerId) {
		return customerRepository.findById(customerId)
				.orElseThrow(() -> new RuntimeException("Müşteri Bulunamadı : " + customerId));
	}

	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(UUID customerId, Customer updatedCustomer) {
		Customer existingCustomer = getCustomerById(customerId);
		existingCustomer.setName(updatedCustomer.getName());
		existingCustomer.setEmail(updatedCustomer.getEmail());
		return customerRepository.save(existingCustomer);
	}

	@Override
	public void deleteCustomer(UUID customerId) {
		Customer customer = getCustomerById(customerId);
		customerRepository.delete(customer);

	}
}
