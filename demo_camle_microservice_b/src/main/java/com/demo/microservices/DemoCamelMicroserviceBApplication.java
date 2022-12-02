package com.demo.microservices;

import com.demo.microservices.config.VaultConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableConfigurationProperties(VaultConfig.class)
public class DemoCamelMicroserviceBApplication implements CommandLineRunner {

    private VaultConfig  vaultConfig;

    public DemoCamelMicroserviceBApplication(VaultConfig vaultConfig) {
        this.vaultConfig = vaultConfig;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoCamelMicroserviceBApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--------valut users details-------");
        System.out.println("userName  --->"+vaultConfig.getUsername());
        System.out.println("Password ---> "+vaultConfig.getPassword());
        System.out.println("--------valut users details-------");

    }
}
