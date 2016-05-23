package com.tacademy.ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tacademy.ecommerce.domain.Order;

public interface OrderRepositoryCustom {

  Page<Order> getOrders(Long userId, Pageable pageable);

}
