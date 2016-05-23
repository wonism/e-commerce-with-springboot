package com.tacademy.ecommerce.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class SystemPropertiesConfig {

  public static final String STORAGE_PATH = "STORAGE_PATH";
  public static final String STORAGE_URI = "STORAGE_URI";

  @Autowired
  private Environment env;

  @Bean
  public MethodInvokingFactoryBean systemPropertiesBean() {
    MethodInvokingFactoryBean bean = new MethodInvokingFactoryBean();
    bean.setTargetObject(System.getProperties());
    bean.setTargetMethod("putAll");

    Properties pros = new Properties();
    pros.setProperty(STORAGE_PATH, env.getProperty("storage.path"));
    pros.setProperty(STORAGE_URI, env.getProperty("storage.uri"));
    bean.setArguments(new Object[] { pros });
    return bean;
  }
}
