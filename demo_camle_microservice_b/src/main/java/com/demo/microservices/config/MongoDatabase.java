//package com.demo.microservices.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
//import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
//import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
//
//import com.mongodb.reactivestreams.client.MongoClient;
//import com.mongodb.reactivestreams.client.MongoClients;
//
//@Configuration
//@EnableReactiveMongoRepositories
//public class MongoDatabase extends AbstractReactiveMongoConfiguration {
//	
//	/*
//	 * @Value("${database}") private String dbName;
//	 */
//
//    @Bean
//    public MongoClient mongoClient() {
//        return MongoClients.create();
//    }
//
//    @Override
//    protected String getDatabaseName() {
//        return "notification";
//    }
//    
//    @Bean
//    public ReactiveMongoTemplate reactiveMongoTemplate() {
//        return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
//    }
//}
