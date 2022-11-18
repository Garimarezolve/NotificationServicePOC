package com.demo.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DemoCamelMicroserviceBApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCamelMicroserviceBApplication.class, args);
    }

}
