package com.demo.microservice.exception;

public class NotificationChannelNotFoundException extends RuntimeException{

    private String message;
    public NotificationChannelNotFoundException(String message) {
        super(message);
        this.message = message;
    }

}
