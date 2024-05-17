package com.javaChallange.business.abstracts;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.javaChallange.entities.concretes.Order;
import com.javaChallange.entities.concretes.OrderItem;

@Service
@Repository
public interface OrderService {

	public Order createOrder(UUID customerId, List<OrderItem> orderItems);

	public Order getOrderById(UUID orderId);

	public Order getOrdersByCustomerId(UUID customerId);

	public void cancelOrder(UUID orderId);
}
