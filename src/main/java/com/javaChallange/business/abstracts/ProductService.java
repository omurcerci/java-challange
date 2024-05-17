package com.javaChallange.business.abstracts;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.javaChallange.entities.concretes.Product;

@Service
@Repository
public interface ProductService {

	// Service parametreleri

	public List<Product> getallProducts();

	public Product getProductById(UUID productId);

	public Product createProduct(Product product);

	public void deleteProduct(UUID productId);

	public Product updateProductPrice(UUID productId, Product updatedProduct);

	public void controlUpdateStock(UUID productId, int quantity);

	public void updateProductPrice(UUID productId, double newPrice);
}
