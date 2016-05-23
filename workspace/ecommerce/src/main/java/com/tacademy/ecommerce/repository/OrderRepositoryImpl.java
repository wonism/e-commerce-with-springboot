package com.tacademy.ecommerce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.mysema.query.jpa.impl.JPAQuery;
import com.tacademy.ecommerce.domain.Order;
import com.tacademy.ecommerce.domain.QOrder;
import com.tacademy.ecommerce.domain.QUser;

public class OrderRepositoryImpl implements OrderRepositoryCustom {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Page<Order> getOrders(Long userId, Pageable pageable) {

    JPAQuery query = new JPAQuery(entityManager);
    QOrder order = QOrder.order;
    QUser user = QUser.user;

    query.from(order).join(order.user, user);
    query.where(user.id.eq(userId));
    query.orderBy(order.orderDate.desc());
    query.limit(pageable.getPageSize()).offset(pageable.getOffset());

    return new PageImpl<Order>(query.list(order), pageable, query.count());
  }

}
