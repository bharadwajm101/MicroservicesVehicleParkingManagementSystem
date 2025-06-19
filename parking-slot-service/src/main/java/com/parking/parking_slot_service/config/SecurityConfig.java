package com.parking.parking_slot_service.config;



 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
 
@Configuration
public class SecurityConfig {
 
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
               
                .requestMatchers(
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/v3/api-docs/**",
                    "/v3/api-docs",
                    "/webjars/**",
                    "/api/slots/**" // Adjust this path as needed for your API endpoints
                ).permitAll()
 
                
                .requestMatchers("/actuator/**").permitAll()
 
                
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults()); // or formLogin() if you're using login form
 
        return http.build();
    }
}
 