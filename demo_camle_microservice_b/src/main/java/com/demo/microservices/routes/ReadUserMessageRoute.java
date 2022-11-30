package com.demo.microservices.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mongodb.MongoDbConstants;

//@Component
public class ReadUserMessageRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
               from("timer://test?repeatCount=1").setHeader(MongoDbConstants.BATCH_SIZE).constant(10)
                 .to("mongodb:mongoBean?database=notification&collection=consumer&operation=findAll")
                 .marshal().json(true)
                       .to("file:\\home\\abhishekr\\Desktop?fileName=test.json")
                 .log("${body}") ;

    }
}
