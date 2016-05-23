package com.tacademy.ecommerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Autowired
  private LoginUserDetailsService userDetailsService;

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  @Order(1)
  public static class FormLoginSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
      return super.authenticationManager();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
      web.ignoring().antMatchers("/resources/**", "/public/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.antMatcher("/admin/**").authorizeRequests()
          .antMatchers("/admin/login").permitAll()
          .antMatchers("/admin/**").hasAnyAuthority(Authorities.ADMIN)
          .and()
          .formLogin().loginPage("/admin/login").usernameParameter("j_username").passwordParameter("j_password")
          .loginProcessingUrl("/admin/j_security_check").defaultSuccessUrl("/admin/product/list").failureUrl("/admin/login?error=true")
          .and()
          .csrf().disable();
    }
  }

  public static class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
      return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
          .antMatchers("/join", "/login", "/product/**").permitAll()
          .antMatchers("/cart/**", "/order/**").hasAnyAuthority(Authorities.USER)
          .and()
          .httpBasic().and()
          .logout()
          .logoutUrl("/j_security_logout").and()
          .csrf().disable();
    }
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
