package com.javaChallange.business.concretes;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaChallange.business.abstracts.OrderService;
import com.javaChallange.dataAccess.abstracts.CustomerRepository;
import com.javaChallange.dataAccess.abstracts.OrderRepository;
import com.javaChallange.dataAccess.abstracts.ProductRepository;
import com.javaChallange.entities.concretes.Customer;
import com.javaChallange.entities.concretes.Order;
import com.javaChallange.entities.concretes.OrderItem;
import com.javaChallange.entities.concretes.Product;

@Service
public class OrderManager implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Order createOrder(UUID customerId, List<OrderItem> orderItems) {

		Customer customer = customerRepository.findById(customerId).orElseThrow();

		// Siparişi oluştur
		Order order = new Order();
		order.setCustomer(customer);

		// Sipariş kalemlerini oluştur ve siparişe ekle
		double totalOrderPrice = 0;
		for (OrderItem itemDTO : orderItems) {
			Product product = productRepository.findById(itemDTO.getProduct().getId())
					.orElseThrow(() -> new RuntimeException("Ürün bulunamadı: "));

			OrderItem orderItem = new OrderItem();
			orderItem.setProduct(product);
			orderItem.setQuantity(itemDTO.getQuantity());
			orderItem.setTotalPrice(product.getPrice() * itemDTO.getQuantity());

			order.getOrderItems().add(orderItem);

			totalOrderPrice += orderItem.getTotalPrice();
		}

		// Siparişin toplam fiyatını güncelle
		order.setTotalPrice(totalOrderPrice);

		orderRepository.save(order);
		return order;
	}

	@Override
	public Order getOrderById(UUID orderId) {
		return orderRepository.findById(orderId)
				.orElseThrow(() -> new RuntimeException("Sipariş bulunamadı: " + orderId));
	}

	@Override
	public Order getOrdersByCustomerId(UUID customerId) {
		return orderRepository.findById(customerId).orElseThrow();
	}

	@Override
	public void cancelOrder(UUID orderId) {
		Order order = getOrderById(orderId);
		orderRepository.delete(order);

	}

}
