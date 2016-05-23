package com.tacademy.ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tacademy.ecommerce.domain.Order;
import com.tacademy.ecommerce.domain.OrderProduct;

public interface OrderRepositoryCustom {

  Page<Order> getOrders(Long userId, Pageable pageable);
  Page<OrderProduct> getOrderProducts(Long userId, Pageable pageable);

}
