package com.javaChallange.dataAccess.abstracts;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaChallange.entities.concretes.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, UUID> {

}
