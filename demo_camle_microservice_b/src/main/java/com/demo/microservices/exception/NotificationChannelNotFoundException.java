package com.demo.microservices.exception;

public class NotificationChannelNotFoundException extends RuntimeException{

    private String message;
    public NotificationChannelNotFoundException(String message) {
        super(message);
        this.message = message;
    }

}
