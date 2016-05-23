package com.tacademy.ecommerce.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_cart")
@Getter @Setter
@ToString(exclude = {"user"})
public class Cart {
	@Id
	private Long id;
	
	@OneToOne(optional=false)
	private User user;
	
	@OneToMany(mappedBy="cart", cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<CartProduct> cartProduct = new HashSet<CartProduct>();

}
