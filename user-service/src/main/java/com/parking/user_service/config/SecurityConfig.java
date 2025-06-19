package com.parking.user_service.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.parking.user_service.service.CustomUserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf->csrf.disable()) 
            .authorizeHttpRequests(auth -> auth
            .requestMatchers(
                "/api/users/register",
                "/api/users/login",
                // "/api/users/**",
                "/v3/api-docs/**",
                "/swagger-ui/**",
                "/swagger-ui.html"
                 // Allowing access to vehicle log endpoints
            )
                .permitAll()
                .anyRequest().authenticated() 
            )
            .userDetailsService(userDetailsService)
            .httpBasic();
        return http.build();
    }
}
