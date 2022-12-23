package com.mastermanagement.mastermanagement.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {
    @Bean
    public ModelMapper modelMapperCourse() {
        return new ModelMapper();
    }
}
