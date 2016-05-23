package com.tacademy.ecommerce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_authority")
@Getter
@Setter
@ToString
public class Authority extends AbstractEntity<Long>implements GrantedAuthority {

  private static final long serialVersionUID = 5803434725021745049L;

  @Id
  @GeneratedValue
  private Long id;

  @Column(length = 30)
  private String authority;

}
