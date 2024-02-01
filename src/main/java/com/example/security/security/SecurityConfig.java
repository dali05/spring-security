package com.example.security.security;

import com.example.security.security.filters.ApiKeyFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Value("${key}")
    private String key;
    @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return http.httpBasic()
               .and()
               .addFilterBefore(new ApiKeyFilter(key), BasicAuthenticationFilter.class)
               .authorizeRequests().anyRequest().authenticated()
               .and().build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }




}
