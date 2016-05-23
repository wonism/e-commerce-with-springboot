package com.tacademy.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.Assert;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

  @Autowired
  private Environment env;

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    String storagePath = env.getProperty("storage.path");
    String storageUri = env.getProperty("storage.uri");
    Assert.hasText(storagePath, "storage.path(application.properties) is empty...");
    Assert.hasText(storageUri, "storage.uri(application.properties) is empty...");
    registry.addResourceHandler(storageUri + "/**").addResourceLocations("file:" + storagePath + "/");
  }

}
