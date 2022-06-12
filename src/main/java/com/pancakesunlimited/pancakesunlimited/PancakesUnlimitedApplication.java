package com.pancakesunlimited.pancakesunlimited;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PancakesUnlimitedApplication {

    public static void main(String[] args) {SpringApplication.run(PancakesUnlimitedApplication.class, args);


    }
    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper=new ModelMapper();

        modelMapper.getConfiguration().setAmbiguityIgnored(true);

        return modelMapper;

    }

}
