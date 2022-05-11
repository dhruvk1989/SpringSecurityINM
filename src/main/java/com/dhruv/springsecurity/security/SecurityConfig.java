package com.dhruv.springsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("dhruv")
                .password(getPasswordEncoder().encode("dhruv@321"))
                .roles("USER")
                .and()
                .withUser("achintya")
                .password(getPasswordEncoder().encode("achintya321"))
                .roles("USER")
                .and()
                .withUser("richa")
                .password(getPasswordEncoder().encode("richa321"))
                .roles("USER")
                .and()
                .withUser("prakash")
                .password(getPasswordEncoder().encode("prakash321"))
                .roles("ADMIN");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("USER", "ADMIN")
                .and().formLogin();
    }
}
