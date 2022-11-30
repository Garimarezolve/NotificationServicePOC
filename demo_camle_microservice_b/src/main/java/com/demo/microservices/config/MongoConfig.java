package com.demo.microservices.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;

public class MongoConfig {
    @Bean("mongoBean")
    public MongoClient getMongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/Notification");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

}

