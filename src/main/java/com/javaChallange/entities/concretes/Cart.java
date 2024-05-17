package com.javaChallange.entities.concretes;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "cart")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	// Her müşterinin bir kartı kayıtlı gibi bir ilişkisel veri tabanı kuralım.
	@OneToOne
	private Customer customer;

	// Bir kartın birden fazla item'ı olabilir.
	@OneToMany(mappedBy = "cart")
	private List<CartItem> cartITems;
}
