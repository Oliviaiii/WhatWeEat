package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/login.html", "/assets/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/index.html") // 指定自定義的登入頁面
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }
}
