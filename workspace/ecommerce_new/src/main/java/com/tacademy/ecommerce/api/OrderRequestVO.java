package com.tacademy.ecommerce.api;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tacademy.ecommerce.common.RequestVO;
import com.tacademy.ecommerce.domain.Order;
import com.tacademy.ecommerce.domain.PayMethod;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderRequestVO extends RequestVO {

  private static final long serialVersionUID = 2969157406177659178L;

  @JsonProperty
  private String recipientName;

  @JsonProperty
  private String deliveryAddress;

  @JsonProperty
  private String recipientTel;

  @JsonProperty
  private PayMethod payMethod;

  @JsonProperty
  private Double orderPrice;

  @JsonProperty
  private List<Data> orderList;

  @Getter
  @Setter
  @NoArgsConstructor
  @RequiredArgsConstructor
  public static class Data implements Serializable {

    private static final long serialVersionUID = -5051152072516713669L;

    @NonNull
    private Long productId;

    @NonNull
    private Integer orderCount;
  }

  public Order toOrderEntity() {
    Order order = new Order();
    order.setRecipientName(this.recipientName);
    order.setDeliveryAddress(this.deliveryAddress);
    order.setRecipientTel(this.recipientTel);
    order.setPayMethod(this.payMethod);
    order.setOrderPrice(this.orderPrice);
    return order;
  }

}
