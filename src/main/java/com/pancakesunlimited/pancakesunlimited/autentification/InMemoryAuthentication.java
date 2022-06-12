package com.pancakesunlimited.pancakesunlimited.autentification;

import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

public class InMemoryAuthentication extends WebSecurityConfigurerAdapter {
    // Adding the roles
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("customer")
                .password("osd")
                .roles("customer_role")
                .and()
                .withUser("employee")
                .password("palacinke")
                .roles("employee_role")
                .and()
                .withUser("owner")
                .password("store")
                .roles("owner_roles");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/ingredients").hasRole("employee_role")
                .antMatchers("/orders","/pancakes").hasAnyRole("customer_role")
                .antMatchers("/reports").hasAnyRole("owner_role")
                .and()
                .formLogin();
    }


    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
