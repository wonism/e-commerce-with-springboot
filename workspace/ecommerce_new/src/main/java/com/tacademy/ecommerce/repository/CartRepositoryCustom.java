package com.tacademy.ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tacademy.ecommerce.domain.CartProduct;

public interface CartRepositoryCustom {

  Page<CartProduct> getCartProducts(Long userId, Pageable pageable);

}
