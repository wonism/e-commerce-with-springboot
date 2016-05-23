package com.tacademy.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

//@Configuration
@PropertySource(value = { "classpath:service.properties",
    "file:${ecom_home}/config/service.properties"}, ignoreResourceNotFound = true)
public class PropertiesConfig {

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
    return configurer;
  }

}
