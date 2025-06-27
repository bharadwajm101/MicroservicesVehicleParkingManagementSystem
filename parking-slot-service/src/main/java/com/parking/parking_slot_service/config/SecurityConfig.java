// package com.parking.parking_slot_service.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http
//             .csrf(csrf -> csrf.disable())
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers(
//                     "/swagger-ui/**",
//                     "/swagger-ui.html",
//                     "/v3/api-docs/**",
//                     "/v3/api-docs",
//                     "/webjars/**",
//                     "/api/slots/**" // Permit all parking slot service endpoints
//                 ).permitAll()
//                 .requestMatchers("/actuator/**").permitAll()
//                 .anyRequest().authenticated() // Require authentication for all other endpoints
//             )
//             .httpBasic(Customizer.withDefaults()); // Use HTTP Basic authentication

//         return http.build();
//     }
// }
