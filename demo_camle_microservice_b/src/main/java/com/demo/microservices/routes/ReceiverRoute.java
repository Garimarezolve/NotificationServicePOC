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
        from("{{receiver.uri}}").unmarshal().json(JsonLibrary.Jackson, Notification.class)
                .bean(notificationProcessor)
        ;

    }
}
