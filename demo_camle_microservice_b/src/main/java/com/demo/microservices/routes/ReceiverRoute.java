package com.demo.microservices.routes;

import com.demo.microservices.dto.Notification;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReceiverRoute extends RouteBuilder {
    @Autowired
    private NotificationProcessor notificationProcessor;

    @Override
    public void configure() throws Exception {
        from("rabbitmq://localhost:5672/testing_mq?queue=testing_mq_queue&autoDelete=false&autoAck=false").unmarshal().json(JsonLibrary.Jackson, Notification.class)
                .bean(notificationProcessor)
                //.to("log:received-message-from-active-mq")
                //.to("activemq:producer-activemq-queue")
                .log("abhis ----->${body}")
                ;

    }
}
