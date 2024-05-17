package com.javaChallange.entities.concretes;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "order")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@ManyToOne
	private Customer customer;

	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems;

	private double totalPrice;
}
