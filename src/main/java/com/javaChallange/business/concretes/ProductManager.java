package com.javaChallange.business.concretes;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaChallange.business.abstracts.ProductService;
import com.javaChallange.dataAccess.abstracts.ProductRepository;
import com.javaChallange.entities.concretes.Product;

@Service
public class ProductManager implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<Product> getallProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(UUID productId) {
		return productRepository.findById(productId)
				.orElseThrow(() -> new RuntimeException("Ürün Bulunamadı : " + productId));
	}

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(UUID productId) {
		Product product = getProductById(productId);
		productRepository.delete(product);

	}

	@Override
	public void updateProductPrice(UUID productId, double newPrice) {
		Product product = getProductById(productId);
		product.setPrice(newPrice);
		productRepository.save(product);

	}

	@Override
	public void controlUpdateStock(UUID productId, int quantity) {
		Product product = getProductById(productId);
		if (product.getStock() < quantity) {
			throw new RuntimeException("Stok yetersiz: " + product.getName());
		}
		product.setStock(product.getStock() - quantity);
		productRepository.save(product);

	}

	@Override
	public Product updateProductPrice(UUID productId, Product updatedProduct) {
		// TODO Auto-generated method stub
		return null;
	}
}
