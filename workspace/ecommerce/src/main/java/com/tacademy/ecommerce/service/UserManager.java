package com.tacademy.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tacademy.ecommerce.domain.Authority;
import com.tacademy.ecommerce.domain.User;
import com.tacademy.ecommerce.repository.AuthorityRepository;
import com.tacademy.ecommerce.repository.UserRepository;

@Service
public class UserManager {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private AuthorityRepository authorityRepository;

  public boolean existUserByUsername(String username) {
    return findByUsername(username) != null;
  }

  @Transactional
  public User save(User user) {
    return userRepository.save(user);
  }

  public User findByUsername(String username) {
    User user = userRepository.findByUsername(username);
    return user;
  }

  public Authority findByAuthority(String authority) {
    return authorityRepository.findByAuthority(authority);
  }


}
