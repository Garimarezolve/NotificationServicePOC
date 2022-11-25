package com.demo.microservices.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.microservices.Repository.NotificationRepository;
import com.demo.microservices.dto.Notification;

@Service
public class UserChannelService{

	@Autowired
	NotificationRepository notificationRepository;

	@Async
	@Transactional
	public void saveNotification(Notification notification) {
		notification.setProcess(false);
		notificationRepository.save(notification);
		 
	}

	@Async
	public void updateNotification(Notification notification) {
		notificationRepository.save(notification);

	}
}
