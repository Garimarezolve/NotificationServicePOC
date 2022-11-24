package com.demo.microservices.routes;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import javax.mail.MessagingException;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.demo.microservices.dto.ChannelProviders;
import com.demo.microservices.dto.Notification;
import com.demo.microservices.interfaces.UserChannelInterface;
import com.demo.microservices.service.NotificationService;
import com.github.mustachejava.Mustache;

@Component
public class UserChannelProcessor {

	Logger logger = LoggerFactory.getLogger(UserChannelProcessor.class);

	@Autowired
	private UserChannelInterface userChannelService;

	@Autowired
	private SingleMustacheFactory singleMustacheFactory;
	@Autowired
	private NotificationService notificationService;

	@Transactional
	public void processMessage(Exchange exchange) throws IOException, MessagingException {

		Notification userChannel = exchange.getIn().getBody(Notification.class);
		StringWriter stringWriter = new StringWriter();
		List<ChannelProviders> channels = userChannel.getChannelProviders();
		channels.parallelStream().forEach(channel -> {
			Mustache mustache = singleMustacheFactory.getMustacheFactory()
					.compile("templates/" + channel.getType().toLowerCase() + ".mustache");
			try {
				mustache.execute(stringWriter, userChannel).flush();
				notificationService.sendNotification(channel.getType(), userChannel.getReceipientEmail(), "Notification Testing",
						stringWriter.toString(), null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		logger.info(stringWriter.toString());
		logger.info("Saving Userchannel messages : " + userChannel.getNotifcationId());
		userChannel.setProcess(true);
		userChannelService.saveUserChannel(userChannel);

	}

}
