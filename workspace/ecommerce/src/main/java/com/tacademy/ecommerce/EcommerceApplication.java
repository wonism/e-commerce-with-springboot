package com.tacademy.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.tacademy.ecommerce.domain.AbstractEntity;
import com.tacademy.ecommerce.security.SpringSecurityAuditorAware;

@SpringBootApplication
@EntityScan(basePackageClasses = AbstractEntity.class)
@EnableJpaAuditing
public class EcommerceApplication {

  public static void main(String[] args) {
    SpringApplication.run(EcommerceApplication.class, args);
  }

  @Bean
  public AuditorAware<Long> auditorProvider() {
    return new SpringSecurityAuditorAware();
  }
}
