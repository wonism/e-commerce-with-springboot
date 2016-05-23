package com.tacademy.ecommerce.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_order_product")
@Getter
@Setter
@ToString(exclude = { "order", "product" })
@NoArgsConstructor
public class OrderProduct extends AbstractEntity<OrderProduct.Id> {

  private static final long serialVersionUID = 7206487735021996949L;

  @EmbeddedId
  private Id id = new Id();

  @ManyToOne
  @MapsId("orderId")
  private Order order;

  @ManyToOne
  @MapsId("productId")
  @JsonProperty
  @JsonUnwrapped
  private Product product;

  @Column(name = "order_count")
  @JsonProperty
  private Integer orderCount;

  public OrderProduct(Order order, Product product) {
    this.id.orderId = order.getId();
    this.id.productId = product.getId();
    this.order = order;
    this.product = product;
  }

  @Embeddable
  @Data
  @EqualsAndHashCode(callSuper = false, of = { "orderId", "productId" })
  public static class Id extends AbstractEntityId {

    private static final long serialVersionUID = 226636815858337409L;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "product_id")
    private Long productId;

  }

}
