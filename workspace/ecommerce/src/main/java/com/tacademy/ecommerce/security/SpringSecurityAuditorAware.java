package com.tacademy.ecommerce.security;


import org.springframework.data.domain.AuditorAware;

import com.tacademy.ecommerce.domain.User;

public class SpringSecurityAuditorAware implements AuditorAware<Long> {
  public Long getCurrentAuditor() {
    User user = getCurrentUser();
    Long id = user == null ? null : user.getId();
    return id;
  }

  private User getCurrentUser() {
    User user = null;
    try {
      user = SecurityUtils.getCurrentUser();
    } catch (RuntimeException ex) {
      // ignored
    }
    return user;
  }

}