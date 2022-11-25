package com.demo.microservices.service;

import java.util.UUID;

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
	public Notification findNotification(String uu) {

		return notificationRepository.findById(uu).orElse(null);

	}

	@Async
	public void updateNotification(Notification notification) {
		notification.setProcess(true);
		notificationRepository.save(notification);

	}
}
