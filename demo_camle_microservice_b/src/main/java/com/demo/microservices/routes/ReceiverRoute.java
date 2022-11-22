package com.demo.microservices.routes;

import com.demo.microservices.dto.UserChannel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;

//@Component
public class ReceiverRoute extends RouteBuilder {
    @Autowired
    private UserChannelProcessor userChannelProcessor;
    @Override
    public void configure() throws Exception {
        from("activemq:my-activemq-queue").unmarshal().json(JsonLibrary.Jackson, UserChannel.class)
                .bean(userChannelProcessor).to("log:received-message-from-active-mq");

    }
}
