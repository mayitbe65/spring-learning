package com.spring.server.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author yu.zhang
 * created on 2021/03/17
 */
@EnableWebSecurity
public class MyWebSecurityConfigure extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
//        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }
}
