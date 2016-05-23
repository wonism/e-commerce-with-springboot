package com.tacademy.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tacademy.ecommerce.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>, CartRepositoryCustom {

}
