package com.tacademy.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tacademy.ecommerce.domain.Product;
import com.tacademy.ecommerce.repository.ProductRepository;
import com.tacademy.ecommerce.repository.UserRepository;

@Service
public class ProductManager {

  @Autowired
  private ProductRepository productRepository;

  public Page<Product> findProducts(Pageable pageable) {
    return productRepository.findByOrderByCreatedDateDesc(pageable);
  }

  public Product findOne(Long id) {
    return productRepository.findOne(id);
  }

  @Transactional
  public Product save(Product product) {
    return productRepository.save(product);
  }

  @Transactional
  public void delete(Long id) {
    productRepository.delete(id);
  }
}
