package com.example.livrariaapi.config;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ModalMapper {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();

    }

}
