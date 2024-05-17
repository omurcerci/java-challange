package com.javaChallange.business.concretes;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.javaChallange.business.abstracts.CartService;
import com.javaChallange.dataAccess.abstracts.CartItemRepository;
import com.javaChallange.dataAccess.abstracts.CartRepository;
import com.javaChallange.dataAccess.abstracts.CustomerRepository;
import com.javaChallange.dataAccess.abstracts.ProductRepository;
import com.javaChallange.entities.concretes.Cart;
import com.javaChallange.entities.concretes.CartItem;
import com.javaChallange.entities.concretes.Customer;
import com.javaChallange.entities.concretes.Product;

import jakarta.transaction.Transactional;

@Service
@Repository
public class CartManager implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CartItemRepository cartItemRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Cart getCartByCustomerId(UUID customerId) {

		Customer customer = customerRepository.findById(customerId).orElseThrow();
		return cartRepository.findByCustomer(customer).orElseThrow();
	}

	@Override
	public Cart createCart(UUID customerId) {
		Customer customer = new Customer();
		customer.setId(customerId);

		Cart cart = new Cart();
		cart.setCustomer(customer);

		return cartRepository.save(cart);
	}

	@Override
	@Transactional
	public void addItemToCart(UUID cartId, UUID productId, int quantity) {
		Cart cart = cartRepository.findById(cartId)
				.orElseThrow(() -> new RuntimeException("Sepet bulunamadı: " + cartId));

		Product product = productRepository.findById(productId).orElseThrow();

//		CartItem cartItem = new CartItem();
//		cartItem.setCart(cart);
//		cartItem.setProduct(product);
//		cartItem.setQuantity(quantity);

		CartItem cartItem = CartItem.builder().cart(cart).product(product).quantity(quantity).build();

		cartItemRepository.save(cartItem);
		cartRepository.save(cart);

	}

	@Override
	public void removeItemFromCart(UUID cartItemId) {
		cartRepository.deleteById(cartItemId);

	}

	@Override
	public void emptyCart(UUID cartId) {
		cartRepository.deleteById(cartId);

	}

	@Override
	public void updateCartItemQuantity(UUID cartItemId, int newQuantity) {
		// TODO Auto-generated method stub

	}
}
