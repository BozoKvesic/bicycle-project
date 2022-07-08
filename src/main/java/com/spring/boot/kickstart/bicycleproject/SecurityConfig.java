package com.spring.boot.kickstart.bicycleproject;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(final HttpSecurity http) throws Exception {
        http
          .cors()
          .and()
          .csrf()
          .disable()
          .antMatcher("/**")
          .authorizeRequests()
          .antMatchers("/")
          .permitAll()
          .anyRequest()
          .authenticated()
          .and()
          .httpBasic();
    }

}