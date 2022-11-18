package com.demo.microservices.routes;

import com.demo.microservices.dto.Channel;
import com.demo.microservices.dto.UserChannel;
import com.demo.microservices.service.NotificationService;
import com.github.mustachejava.Mustache;
import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

@Component
public class UserChannelProcessor {


    Logger logger = LoggerFactory.getLogger(UserChannelProcessor.class);

    @Autowired
    private NotificationService notificationService;


    @Autowired
    private SingleMustacheFactory singleMustacheFactory;


    public void processMessage(Exchange exchange) throws IOException, MessagingException {

        UserChannel userChannel = exchange.getIn().getBody(UserChannel.class);
        StringWriter stringWriter = new StringWriter();
        List<Channel> channels=userChannel.getChannels();
        channels.parallelStream().forEach(channel ->{
            Mustache  mustache =  singleMustacheFactory.getMustacheFactory()
                    .compile("templates/"+channel.getType().toLowerCase()+".mustache");
            try {
                mustache.execute(stringWriter, userChannel).flush();
                notificationService.sendNotification(channel.getType(),channel.getContact(),
                        "Notification Testing",stringWriter.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        logger.info(stringWriter.toString());

    }

}
