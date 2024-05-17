package com.javaChallange.webApi.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaChallange.business.abstracts.ProductService;
import com.javaChallange.entities.concretes.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/getAll")
	public List<Product> getallProducts() {
		return productService.getallProducts();
	}

	@GetMapping("/getById/{productId}")
	public Product getProductById(@PathVariable UUID productId) {
		return productService.getProductById(productId);
	}

	@PostMapping("/create")
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@PutMapping("/updateProduct/{productId}")
	public Product updateProduct(@PathVariable UUID productId, @RequestBody Product updatedProduct) {
		return productService.updateProductPrice(productId, updatedProduct);
	}

	@DeleteMapping("/deleteProduct/{productId}")
	public void deleteProduct(@PathVariable UUID productId) {
		productService.deleteProduct(productId);
	}

	@PatchMapping("/updatePrice/{productId}")
	public void updateProductPrice(@PathVariable UUID productId, @RequestParam double newPrice) {
		productService.updateProductPrice(productId, newPrice);
	}

}
