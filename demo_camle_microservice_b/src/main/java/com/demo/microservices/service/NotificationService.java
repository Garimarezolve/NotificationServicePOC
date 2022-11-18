package com.demo.microservices.service;


import com.demo.microservices.adapterImpl.EmailAdapterImpl;
import com.demo.microservices.dto.NotificationEnum;
import com.demo.microservices.interfaces.NotificationAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class NotificationService {
    private JavaMailSender javaMailSender;
    @Autowired
    public NotificationService(JavaMailSender javaMailSender){
        this.javaMailSender=javaMailSender;
        notificationMap.put(NotificationEnum.EMAIL.toString(),new EmailAdapterImpl(javaMailSender));
    }
    private Map<String, NotificationAdapter> notificationMap = new HashMap<>();


    public void sendNotification(String type,String to ,String content,String subject) {
            if(notificationMap.get(type.toUpperCase())!=null)
            notificationMap.get(type.toUpperCase()).sendNotification(to,subject,content);
            else
                System.out.println("Invalid Type");
    }
}
