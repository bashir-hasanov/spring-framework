package com.cydeo.bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigEmployee {

    @Bean
    public FullTimeEmployee fullTimeEmployee() {
        return new FullTimeEmployee();
    }

    @Bean
    public PartTimeEmployee partTimeEmployee() {
        return new PartTimeEmployee();
    }
}
