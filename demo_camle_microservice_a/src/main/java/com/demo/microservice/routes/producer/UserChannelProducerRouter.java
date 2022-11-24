package com.demo.microservice.routes.producer;

import com.demo.microservice.dto.ChannelProviders;

import com.demo.microservice.dto.Notification;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import static org.apache.camel.LoggingLevel.INFO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Component
public class UserChannelProducerRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        List<ChannelProviders>channels=new ArrayList<>();
    	channels.add(new ChannelProviders("email","XYZ"," Resolve_sms_provider_123xyz","1"));
    	LocalDateTime lt
        = LocalDateTime.now();
    	from("timer://runOnce?repeatCount=10&delay=5000").loop(10000)
		.setBody(constant(mapper.writeValueAsString(
               new Notification("Rezolve_system_01_D0A40BC8-F84C-4B2C-97B4-C3C1B1E31BC7", 
            		   "Rezolve_system_01", "ravikhitolia.it@gmail.com", "return_url",
            		   "UK", "Rezolve_email_checkout_v1_en", "Email", "1", "en",
            		   lt, lt,channels
           
                
                		))))
		.to("rabbitmq://localhost:5672/testing_mq?queue=testing_mq_queue&autoDelete=false")
	 .log(INFO, "After pushing: ${body}");

    }
}
