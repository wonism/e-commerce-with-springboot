package com.tacademy.ecommerce.domain;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="t_order")
@Getter @Setter
@ToString(exclude={"orderProducts"})
public class Order {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="order_date")
	private Date orderDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name="order_status")
	private OrderStatus orderStatus;
	
	@Enumerated(EnumType.STRING)
	@Column(name="pay_method")
	private PayMethod payMethod;
	
	@Column(name="order_price")
	private Double orderPrice;
	
	@OneToMany(mappedBy="order", cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<OrderProduct> orderProducts;
	
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName="id" )
	private User user;
	
	@Column(name="recipient_name", length=30)
	private String recipientName;
	
	@Column(name="delevery_address", length=255)
	private String deliveryAddress;
	
	@Column(name="recipient_tel", length=15)
	private String recipientTel;
	
}
