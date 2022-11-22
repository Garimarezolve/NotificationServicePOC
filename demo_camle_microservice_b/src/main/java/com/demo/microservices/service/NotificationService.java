package com.demo.microservices.service;


import com.demo.microservices.adapterImpl.EmailAdapterImpl;
import com.demo.microservices.adapterImpl.WhatsAppAdapterImpl;
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
         notificationMap.put(NotificationEnum.SMS.toString(),new WhatsAppAdapterImpl());
    }
//    @Autowired
//    public NotificationService(){
//        notificationMap.put(NotificationEnum.SMS.toString(),new WhatsAppAdapterImpl());
//    }
    private Map<String, NotificationAdapter> notificationMap = new HashMap<>();


    public void sendNotification(String type,String to ,String content,String subject,String countryCode) {
        for (String str:notificationMap.keySet()) {
            if(str.equalsIgnoreCase("email"))
                notificationMap.get(type.toUpperCase()).sendNotification(to,subject,content,countryCode);
            else{
                notificationMap.get(type.toUpperCase()).sendNotification(to,subject,content,countryCode);
             }
    }


    }
}
