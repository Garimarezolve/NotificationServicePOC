package com.demo.microservices.routes;

import java.io.IOException;

import javax.mail.MessagingException;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.demo.microservices.dto.UserChannel;
import com.demo.microservices.interfaces.UserChannelInterface;

@Component
public class UserChannelProcessor {

	Logger logger = LoggerFactory.getLogger(UserChannelProcessor.class);

	@Autowired
	private UserChannelInterface userChannelService;

	@Transactional
	public void processMessage(Exchange exchange) throws IOException, MessagingException {

		UserChannel userChannel = exchange.getIn().getBody(UserChannel.class);
		//userChannel.setId(UUID.randomUUID().toString());
		logger.info("Saving Userchannel messages : " + userChannel.getUserID());
		userChannelService.saveUserChannel(userChannel);

		/*
		 * StringWriter stringWriter = new StringWriter(); List<Channel>
		 * channels=userChannel.getChannels(); channels.parallelStream().forEach(channel
		 * ->{ Mustache mustache = singleMustacheFactory.getMustacheFactory()
		 * .compile("templates/"+channel.getType().toLowerCase()+".mustache"); try {
		 * mustache.execute(stringWriter, userChannel).flush();
		 * notificationService.sendNotification(channel.getType(),channel.getContact(),
		 * "Notification Testing",stringWriter.toString(),userChannel.getCountryCode());
		 * } catch (IOException e) { e.printStackTrace(); } });
		 * logger.info(stringWriter.toString());
		 */
	}

}
