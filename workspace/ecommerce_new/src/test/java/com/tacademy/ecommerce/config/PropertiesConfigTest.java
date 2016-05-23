package com.tacademy.ecommerce.config;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.tacademy.ecommerce.EcommerceApplicationTests;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
public class PropertiesConfigTest extends EcommerceApplicationTests {

  @Autowired
  Environment env;

  @Test
  public void test() {
    log.debug(env.getProperty("spring.datasource.username"));
    log.debug(env.getProperty("spring.datasource.url"));
  }
}
