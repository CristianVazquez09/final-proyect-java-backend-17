package com.mycompany.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    // Método para hacer match con ModelMapper
    @Bean ("studentMapper")
    public ModelMapper StudentMapper() {

        return new ModelMapper();
    }

    @Bean ("defaultMapper")
    public ModelMapper defaultMapper() {
        return new ModelMapper();
    }
}
