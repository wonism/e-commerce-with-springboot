package com.tacademy.ecommerce.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_cart")
@Getter
@Setter
@ToString(exclude = { "user" })
public class Cart extends AbstractEntity<Long> {

  private static final long serialVersionUID = 6456906977955293959L;

  @Id
  private Long id;

  @OneToOne(optional = false)
  @MapsId
  @JoinColumn(name = "id")
  private User user;

  @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<CartProduct> cartProducts = new HashSet<CartProduct>();

}
