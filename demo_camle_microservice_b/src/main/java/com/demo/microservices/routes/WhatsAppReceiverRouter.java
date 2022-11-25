package com.demo.microservices.routes;

import com.demo.microservices.dto.Notification;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;

//@Component
public class WhatsAppReceiverRouter extends RouteBuilder {

    @Autowired
    private NotificationProcessor notificationProcessor;

    @Override
    public void configure() throws Exception {
            from("activemq:my-activemq-queue").unmarshal().json(JsonLibrary.Jackson, Notification.class)
                    .bean(notificationProcessor).to("log:received-message-from-active-mq");

        }
}
