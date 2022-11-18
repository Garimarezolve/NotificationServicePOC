package com.demo.microservices.interfaces;

public interface NotificationAdapter {
    public void sendNotification(String to ,String subject ,String content);
}
