package com.example.koun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class KounApplication {

    public static void main(String[] args) {
        SpringApplication.run(KounApplication.class, args);
    }

}
