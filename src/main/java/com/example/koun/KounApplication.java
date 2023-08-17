package com.example.koun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.example.koun.domain.Item;
import com.example.koun.repository.ItemRepository;

import java.time.LocalDate;

@SpringBootApplication
public class KounApplication {

    public static void main(String[] args) {

        SpringApplication.run(KounApplication.class, args);

    }

}