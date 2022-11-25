package com.demo.microservices.interfaces;

import com.demo.microservices.dto.Notification;

public interface NotificationInterface {

	public void saveNotification(Notification notification);

	public void updateNotification(Notification notification);

}
