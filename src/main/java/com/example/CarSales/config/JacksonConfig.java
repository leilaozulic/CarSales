package com.example.CarSales.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    //JSON
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
