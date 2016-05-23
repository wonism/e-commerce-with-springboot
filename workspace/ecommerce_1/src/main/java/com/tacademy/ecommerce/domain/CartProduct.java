package com.tacademy.ecommerce.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="t_cart_product")
@Getter @Setter
@ToString(exclude={"cart", "product"})
@NoArgsConstructor
public class CartProduct {
	@EmbeddedId
	private Id id = new Id();
	
	@ManyToOne
	@MapsId("cartId")
	private Cart cart;
	
	@ManyToOne
	@MapsId("productId")
	private Product product;	
	
	@Column(name = "buy_count")
	private Integer buyCount;
		
	public CartProduct(Cart cart, Product product) {
		this.id.cartId = cart.getId();
		this.id.productId = product.getId();
		this.cart = cart;
		this.product = product;
	}
	
	@Embeddable
	@Data
	@EqualsAndHashCode(of={"cartId", "productId"})
	public static class Id implements Serializable {
		@Column(name="cart_id")
		private Long cartId;
		
		@Column(name = "product_id")
		private Long productId;
	}	
}
