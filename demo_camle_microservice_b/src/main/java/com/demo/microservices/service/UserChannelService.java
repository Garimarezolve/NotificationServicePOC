package com.demo.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.demo.microservices.Repository.UserChannelRepository;
import com.demo.microservices.dto.Notification;
import com.demo.microservices.interfaces.UserChannelInterface;

@Service
public class UserChannelService implements UserChannelInterface {

	@Autowired
	UserChannelRepository userChannelRepository;

	@Override
	@Async
	public void saveUserChannel(Notification userChannel) {
		userChannelRepository.save(userChannel);

	}
}
