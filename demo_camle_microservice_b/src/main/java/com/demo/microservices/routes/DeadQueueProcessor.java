package com.demo.microservices.routes;

import com.demo.microservices.Repository.NotificationRepository;
import com.demo.microservices.dto.Notification;
import com.demo.microservices.service.NotificationService;
import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;

@Component
public class DeadQueueProcessor {

    Logger logger = LoggerFactory.getLogger(DeadQueueProcessor.class);
    @Autowired
    NotificationRepository notificationRepository;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private SingleMustacheFactory singleMustacheFactory;


    public void processMessage(Exchange exchange) throws IOException, MessagingException {

        Notification notification = exchange.getIn().getBody(Notification.class);

        notificationRepository.save(notification);

    }

}
