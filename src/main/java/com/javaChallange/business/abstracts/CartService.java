package com.javaChallange.business.abstracts;

import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.javaChallange.entities.concretes.Cart;

@Repository
@Service
public interface CartService {

	public Cart getCartByCustomerId(UUID customerId);

	public Cart createCart(UUID customerId);

	public void addItemToCart(UUID cartId, UUID productId, int quantity);

	public void removeItemFromCart(UUID cartItemId);

	public void emptyCart(UUID cartID);

	public void updateCartItemQuantity(UUID cartItemId, int newQuantity);
}
