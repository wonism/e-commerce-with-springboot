package com.tacademy.ecommerce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.mysema.query.jpa.impl.JPAQuery;
import com.tacademy.ecommerce.domain.CartProduct;
import com.tacademy.ecommerce.domain.QCart;
import com.tacademy.ecommerce.domain.QCartProduct;
import com.tacademy.ecommerce.domain.QProduct;
import com.tacademy.ecommerce.domain.QUser;

public class CartRepositoryImpl implements CartRepositoryCustom {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Page<CartProduct> getCartProducts(Long userId, Pageable pageable) {
 
    JPAQuery query = new JPAQuery(entityManager);
    QCartProduct cartProduct = QCartProduct.cartProduct;
    QCart cart = QCart.cart;
    QUser user = QUser.user;

    query.from(cartProduct).join(cartProduct.cart, cart).join(cart.user, user);
    query.where(user.id.eq(userId));
    query.orderBy(cartProduct.createdDate.desc());
    query.limit(pageable.getPageSize()).offset(pageable.getOffset());

    return new PageImpl<CartProduct>(query.list(cartProduct), pageable, query.count());
  }



}
