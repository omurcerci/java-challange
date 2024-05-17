package com.javaChallange.webApi.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaChallange.business.abstracts.CartService;
import com.javaChallange.dto.cart.AddCartItemRequest;
import com.javaChallange.entities.concretes.Cart;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("/createCart/{customerId}")
	public Cart createCart(@PathVariable UUID customerId) {
		return cartService.createCart(customerId);
	}

	@PostMapping("/itemAdd")
	public void addItemToCart(@RequestBody AddCartItemRequest request) {
		cartService.addItemToCart(request.getCartId(), request.getProductId(), request.getQuantity());
	}

	@PutMapping("/addCartItems/{cartItemId}")
	public void updateCartItemQuantity(@PathVariable UUID cartItemId, @RequestParam int newQuantity) {
		cartService.updateCartItemQuantity(cartItemId, newQuantity);
	}

	@DeleteMapping("/deleteCartItems/{cartItemId}")
	public void removeItemFromCart(@PathVariable UUID cartItemId) {
		cartService.removeItemFromCart(cartItemId);
	}

	@GetMapping("/getCustomerCart/{customerId}")
	public Cart getCartByCustomerId(@PathVariable UUID customerId) {
		return cartService.getCartByCustomerId(customerId);
	}
}
