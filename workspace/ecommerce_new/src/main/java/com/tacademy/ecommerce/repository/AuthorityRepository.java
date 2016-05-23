package com.tacademy.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tacademy.ecommerce.domain.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

  Authority findByAuthority(String name);
}
