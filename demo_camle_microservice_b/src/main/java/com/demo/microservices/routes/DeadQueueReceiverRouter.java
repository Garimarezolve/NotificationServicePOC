package com.demo.microservices.routes;

import com.demo.microservices.dto.Notification;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeadQueueReceiverRouter extends RouteBuilder {
    @Autowired
    private DeadQueueProcessor deadQueueProcessor;

    @Override
    public void configure() throws Exception {

        from("rabbitmq:originalexchange?exchangeType=topic&routingKey=org&queue=originalequeue&declare=false&autoDelete=false&arg.queue.x-message-ttl=15000&autoAck=false&deadLetterExchange=duplicate&deadLetterExchangeType=topic&deadLetterRoutingKey=dup&deadLetterQueue=duplicatequeue")

                .unmarshal().json(JsonLibrary.Jackson, Notification.class)
                .bean(deadQueueProcessor).to("log:received-message-from-rabbit-mq")

                .to("log:received-message-from-rabbit-mq");

//                from("rabbitmq:duplicate&LetterQueue=duplicatequeue&deadLetterRoutingKey=dup")
//        from("rabbitmq://localhost:5672/testing_mq?queue=testing_mq_queue&autoDelete=false&autoAck=false")
//                .to("log:deadLetter-rabbitmq-")
        ;
//.to("rabbitmq:originalexchange?exchangeType=topic&routingKey=org&queue=originalequeue&arg.queue.x-message-ttl=15000&autoAck=false&deadLetterExchange=duplicate&deadLetterExchangeType=topic&deadLetterRoutingKey=dup&deadLetterQueue=duplicatequeue")
//        from("rabbitmq:duplicate?exchangeType=topic&routingKey=dup&queue=duplicatequeue")
////                .to("hello log:${body}")
//                .to("log:duplicatequeue")
//                .to("rabbitmq:originalexchange?exchangeType=topic&routingKey=org&queue=originalequeue&arg.queue.x-message-ttl=15000&deadLetterExchange=duplicate&deadLetterExchangeType=topic&autoAck=false&deadLetterRoutingKey=dup&deadLetterQueue=duplicatequeue")
//
////                        .to("rabbitmq:originalexchange?exchangeType=topic&routingKey=org&queue=originalequeue&arg.queue.x-message-ttl=15000")
//                .to("log:myLoggingQueue")
//                .to("log:data wright to original queue");
    }
}
