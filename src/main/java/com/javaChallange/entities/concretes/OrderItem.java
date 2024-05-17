package com.javaChallange.entities.concretes;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "order_items")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@ManyToOne
	private Product product;

	@ManyToOne
	private Order order;

	private int quantity;
	private double totalPrice;
}