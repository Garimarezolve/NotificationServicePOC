package com.demo.microservices.routes;

import com.demo.microservices.dto.Notification;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class DeadQueueReceiverRouter extends RouteBuilder {
    @Autowired
    private DeadQueueProcessor deadQueueProcessor;

    @Override
    public void configure() throws Exception {

        from("{{dead.queue.receive.uri}}")

                .unmarshal().json(JsonLibrary.Jackson, Notification.class)
                .bean(deadQueueProcessor).to("log:received-message-from-rabbit-mq")
                .to("log:received-message-from-rabbit-mq");


    }
}
