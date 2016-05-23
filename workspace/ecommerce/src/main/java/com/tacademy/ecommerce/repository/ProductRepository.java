package com.tacademy.ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tacademy.ecommerce.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

  Page<Product> findByOrderByCreatedDateDesc(Pageable pageable);
}
