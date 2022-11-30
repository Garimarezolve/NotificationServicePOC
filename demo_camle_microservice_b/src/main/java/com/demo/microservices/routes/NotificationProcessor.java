package com.demo.microservices.routes;

import com.demo.microservices.dto.ChannelProviders;
import com.demo.microservices.dto.Notification;
import com.demo.microservices.exception.NotificationChannelNotFoundException;
import com.demo.microservices.service.NotificationService;
import com.demo.microservices.service.ReadGitURLService;
import com.demo.microservices.service.UserChannelService;
import com.github.mustachejava.Mustache;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

@Component
public class NotificationProcessor {
    private ReadGitURLService readGitURLService = new ReadGitURLService();
    @Autowired
    private UserChannelService notificationInterface;
    @Autowired
    private SingleMustacheFactory singleMustacheFactory;
    @Autowired
    private NotificationService notificationService;

    @Transactional
    public void processMessage(Exchange exchange) throws IOException, MessagingException {

        Notification notification = exchange.getIn().getBody(Notification.class);
        notification.setId(notification.getNotifcationId());
        notificationInterface.saveNotification(notification);
        List<ChannelProviders> channels = notification.getChannelProviders();
        StringWriter stringWriter = new StringWriter();
        channels.parallelStream().forEach(channel -> {
            try {
                readGitURLService.readFileURL();
                Mustache mustache = singleMustacheFactory.getMustacheFactory()
                        .compile("templates/" + channel.getType().toLowerCase() + ".mustache");
                mustache.execute(stringWriter, notification).flush();
                notificationService.sendNotification(channel.getType(), notification.getReceipientEmail(), "Notification Testing",
                        stringWriter.toString(), null);
                notification.setProcess(true);

                notificationInterface.updateNotification(notification);


            } catch (IOException e) {
                throw new NotificationChannelNotFoundException("Email Does not exits");
            }
        });

    }

}
