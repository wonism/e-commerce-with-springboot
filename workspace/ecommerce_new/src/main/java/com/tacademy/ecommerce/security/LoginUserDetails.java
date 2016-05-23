package com.tacademy.ecommerce.security;

import com.tacademy.ecommerce.domain.User;

import lombok.Getter;

@Getter
public class LoginUserDetails extends org.springframework.security.core.userdetails.User{

	private static final long serialVersionUID = -3568885757010981354L;

	private User user;

	public LoginUserDetails(User user) {
		super(user.getUsername(), user.getPassword(), user.getAuthorities());
		this.user = user;
		
		System.out.println("login okok");
	}
}
