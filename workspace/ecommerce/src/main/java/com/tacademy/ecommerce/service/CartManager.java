package com.tacademy.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tacademy.ecommerce.domain.Cart;
import com.tacademy.ecommerce.domain.CartProduct;
import com.tacademy.ecommerce.domain.Product;
import com.tacademy.ecommerce.repository.CartRepository;
import com.tacademy.ecommerce.repository.ProductRepository;

@Service
public class CartManager {

  @Autowired
  private CartRepository cartRepository;

  @Autowired
  private ProductRepository productRepository;

  public Page<CartProduct> getCartProducts(Long userId, Pageable pageable) {
    return cartRepository.getCartProducts(userId, pageable);
  }

  @Transactional
  public void addProduct(Long userId, Long productId, Integer buyCount) {
    Cart cart = cartRepository.findOne(userId);
    Product product = productRepository.findOne(productId);
    CartProduct cartProduct = new CartProduct(cart, product);
    cartProduct.setBuyCount(buyCount);
    cart.getCartProducts().add(cartProduct);
  }

  @Transactional
  public void deleteProduct(Long userId, Long productId) {
    Cart cart = cartRepository.findOne(userId);
    Product product = productRepository.findOne(productId);
    CartProduct cartProduct = new CartProduct(cart, product);
    cart.getCartProducts().remove(cartProduct);
  }

}
