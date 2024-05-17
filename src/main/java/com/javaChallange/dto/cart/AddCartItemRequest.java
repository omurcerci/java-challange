package com.javaChallange.dto.cart;

import java.util.UUID;

import lombok.Data;

@Data
public class AddCartItemRequest {

	private UUID cartId;
	private UUID productId;
	private int quantity;
}
