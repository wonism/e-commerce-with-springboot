package com.tacademy.ecommerce.service;

import lombok.extern.apachecommons.CommonsLog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tacademy.ecommerce.EcommerceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EcommerceApplication.class)
@WebAppConfiguration
@CommonsLog
public class UserManagerTest extends AbstractTransactionalJUnit4SpringContextTests {

  @Autowired
  private UserManager userManager;

  @Test
  public void testFindByUsername() throws Exception {
    log.debug(userManager.findByUsername("user01"));
  }

}
