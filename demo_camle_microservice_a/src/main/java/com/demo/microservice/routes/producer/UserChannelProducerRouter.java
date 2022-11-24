package com.demo.microservice.routes.producer;

import com.demo.microservice.dto.Channel;

import com.demo.microservice.dto.UserChannel;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.GroupedBodyAggregationStrategy;
import org.springframework.stereotype.Component;
import static org.apache.camel.LoggingLevel.INFO;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Component
@Slf4j
public class UserChannelProducerRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        List<Channel>channels=new ArrayList<>();
//         channels.add(new Channel("email","garima.sharma513@gmail.com"));
//        channels.add(new Channel("sms","8904641847"));
//        from("timer:active-mq-timer?period=1").setBody(constant(mapper.writeValueAsString(
//                         new UserChannel(UUID.randomUUID().toString(),
//                                  "India","91","Garima",channels))))
//                .to("activemq:my-activemq-queue")
//                .to("log:myLoggingQueue");
        
//    	ObjectMapper mapper = new ObjectMapper();
//    	List<Channel> channels=new ArrayList<>();
    	channels.add(new Channel("email","garima.sharma513@gmail.com"));
    	channels.add(new Channel("sms","8904641847"));
//    	from("timer:rabbit-mq-timer?period=1000")
//    	        .threads(15).loop(10000).aggregate(constant(true)
//    	                ,new GroupedBodyAggregationStrategy())
//    	                 .completionSize(10000).parallelProcessing()
//    	        .setBody(constant(mapper.writeValueAsString(
//    	                new UserChannel(UUID.randomUUID().toString(),
//    	                        "India","91","Garima",channels))))
//    	        .to("rabbitmq://localhost:5672/notification.exchange?queue=test")
//    	        .to("log:myLoggingQueue");
    	from("timer://runOnce?repeatCount=10&delay=5000").loop(10000)
		.setBody(constant(mapper.writeValueAsString(
                new UserChannel(UUID.randomUUID().toString(),
                        "India","91","Garima",channels)))).
		to("rabbitmq://localhost:5672/testing_mq?queue=testing_mq_queue&autoDelete=false")
	 .log(INFO, "After pushing: ${body}");

    }
}
