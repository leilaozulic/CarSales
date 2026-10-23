package com.example.CarSales.config;

import com.example.CarSales.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http,
                                            CustomUserDetailsService userDetailsService)

        /*
            defines the rules Spring Security applies to incoming requests
         */
            throws Exception {

        http
                .userDetailsService(userDetailsService)
                .authorizeHttpRequests(auth -> auth //auth is auth object through which we define auth rules
                        .requestMatchers(                                         //configuring auth rules for HTTP requests
                                "/",
                                "/login",
                                "/signup",
                                "/verify-email",
                                "/assets/**",
                                "/css/**",
                                "/favicon.ico"
                        ).permitAll()                                             //these domains are public and we don't require user to be logged in for them
                        .anyRequest().authenticated()                             // all other requests need to be authenticated
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .usernameParameter("email")
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/login?error")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                );

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        /*
                registers a password encoder in Spring's application context so other components can inject and use it
         */
        return new BCryptPasswordEncoder();
    }
}
