package com.javaChallange.webApi.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaChallange.business.abstracts.OrderService;
import com.javaChallange.entities.concretes.Order;
import com.javaChallange.entities.concretes.OrderItem;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/{customerId}")
	public Order createOrder(@PathVariable UUID customerId, @RequestBody List<OrderItem> orderItems) {
		return orderService.createOrder(customerId, orderItems);
	}

	@GetMapping("/{orderId}")
	public Order getOrderById(@PathVariable UUID orderId) {
		return orderService.getOrderById(orderId);
	}

	@GetMapping("/customer/{customerId}")
	public Order getOrdersByCustomerId(@PathVariable UUID customerId) {
		return orderService.getOrdersByCustomerId(customerId);
	}

	@DeleteMapping("/{orderId}")
	public void cancelOrder(@PathVariable UUID orderId) {
		orderService.cancelOrder(orderId);
	}

}
