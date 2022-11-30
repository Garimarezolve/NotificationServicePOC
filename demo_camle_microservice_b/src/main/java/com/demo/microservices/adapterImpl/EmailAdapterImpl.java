package com.demo.microservices.adapterImpl;

import com.demo.microservices.interfaces.NotificationAdapter;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;

public class EmailAdapterImpl implements NotificationAdapter {


    private JavaMailSender javaMailSender;

    public EmailAdapterImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    @Async
    public void sendNotification(String to, String subject, String content, String countryCode) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        javaMailSender.send(message);

    }
}
