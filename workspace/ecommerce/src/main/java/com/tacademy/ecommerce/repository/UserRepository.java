package com.tacademy.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tacademy.ecommerce.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByUsername(String username);
}
