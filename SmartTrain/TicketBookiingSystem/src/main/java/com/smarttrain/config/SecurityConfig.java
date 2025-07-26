package com.smarttrain.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.smarttrain.filter.JwtAuthFilter;
import com.smarttrain.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
    private JwtAuthFilter jwtAuthFilter;
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	   return http
    	            .csrf(csrf -> csrf.disable())
    	            .authorizeHttpRequests(auth -> auth
    	            	    .requestMatchers("/auth/**").permitAll()
    	            	    .requestMatchers("/admin/**").hasRole("ADMIN")
    	            	    .requestMatchers("/user/**").hasRole("USER")
    	            	    .anyRequest().authenticated()
    	            )
    	            .sessionManagement(session -> session
    	                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    	            )
    	            .authenticationProvider(authenticationProvider())
    	            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
    	            .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
    	  DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    	    authProvider.setUserDetailsService(userDetailsService()); // call method
    	    authProvider.setPasswordEncoder(passwordEncoder());       // call method
    	    return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                   .userDetailsService(userDetailsService())
                   .passwordEncoder(passwordEncoder())
                   .and()
                   .build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService(); // Your own implementation
    }

   
}

