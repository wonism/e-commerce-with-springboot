package com.tacademy.ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tacademy.ecommerce.domain.Order;
import com.tacademy.ecommerce.domain.OrderStatus;

public interface OrderRepository extends JpaRepository<Order, Long>, OrderRepositoryCustom {

  Page<Order> findByOrderByOrderDateDesc(Pageable pageable);

  Page<Order> findByOrderStatusOrderByOrderDateDesc(OrderStatus orderStatus, Pageable pageable);
}
