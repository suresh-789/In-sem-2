package com.example.medicalappointmentsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // ✅ Disable CSRF for stateless REST APIs
            .csrf(csrf -> csrf.disable())

            // ✅ Enable CORS (can be further configured in WebMvcConfig)
            .cors(cors -> {})

            // ✅ Authorization rules
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()            // login/register
                .requestMatchers(new AntPathRequestMatcher("/api/users/**")).permitAll()       // user management
                .requestMatchers(new AntPathRequestMatcher("/api/appointments/**")).permitAll()// appointments
                .requestMatchers(new AntPathRequestMatcher("/api/records/**")).permitAll()     // medical records
                .anyRequest().authenticated()                                                  // anything else requires auth
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
