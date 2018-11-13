package com.javapro.costs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    UserDetails user = User.withDefaultPasswordEncoder().username("user").password("123").roles("USER").build();
    UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("123").roles("ADMIN").build();

    auth.inMemoryAuthentication().withUser(user);
    auth.inMemoryAuthentication().withUser(admin);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/test/**").access("hasRole('ROLE_ADMIN')")
        .antMatchers("/purchases/**").access("hasRole('ROLE_USER')")
        .and().formLogin();
  }
}
