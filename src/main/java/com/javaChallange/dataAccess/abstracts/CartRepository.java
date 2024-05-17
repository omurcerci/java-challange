package com.javaChallange.dataAccess.abstracts;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javaChallange.entities.concretes.Cart;
import com.javaChallange.entities.concretes.Customer;

@Repository
public interface CartRepository extends JpaRepository<Cart, UUID> {

	@Query("SELECT c FROM Cart c WHERE c.customer = :customer")
	Optional<Cart> findByCustomer(Customer customer);
}
