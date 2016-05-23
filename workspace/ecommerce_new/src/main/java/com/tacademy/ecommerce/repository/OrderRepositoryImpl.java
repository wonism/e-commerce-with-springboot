package com.tacademy.ecommerce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.mysema.query.jpa.impl.JPAQuery;
import com.tacademy.ecommerce.domain.Order;
import com.tacademy.ecommerce.domain.OrderProduct;
import com.tacademy.ecommerce.domain.QOrder;
import com.tacademy.ecommerce.domain.QOrderProduct;
import com.tacademy.ecommerce.domain.QProduct;
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

  @Override
  public Page<OrderProduct> getOrderProducts(Long userId, Pageable pageable) {
	  
	    JPAQuery query = new JPAQuery(entityManager);
	    QOrderProduct orderProduct = QOrderProduct.orderProduct;
	    QOrder order = QOrder.order;
	    QProduct product = QProduct.product;

	    query.from(orderProduct).join(orderProduct.order, order).join(orderProduct.product, product);
	    query.where(orderProduct.createdBy.eq(userId));
	    query.orderBy(orderProduct.createdDate.desc());
	    query.limit(pageable.getPageSize()).offset(pageable.getOffset());

	    return new PageImpl<OrderProduct>(query.list(orderProduct), pageable, query.count());	  
	  
  }

}
