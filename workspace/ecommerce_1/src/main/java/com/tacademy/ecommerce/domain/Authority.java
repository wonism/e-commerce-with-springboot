package com.tacademy.ecommerce.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="t_authority")
@Data
@EqualsAndHashCode(callSuper=false)
public class Authority extends AbstractEntity<Long> implements GrantedAuthority{
	private static final long serialVersionUID = -7104262074036556643L;

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToMany(mappedBy = "authorities")
	public Set<User> users;
	
	@Column(length=30)
	private String authority;

}
