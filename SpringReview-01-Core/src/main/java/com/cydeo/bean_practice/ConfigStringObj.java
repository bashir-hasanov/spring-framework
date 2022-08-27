package com.cydeo.bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfigStringObj {

    //@Bean (name = "message1)
    @Bean
    @Primary
    public String message1() {
        return "Welcome to CydeoApp!";
    }

    //@Bean (name = "message2)
    @Bean
    public String message2() {
        return "Spring Core Practice";
    }
}
