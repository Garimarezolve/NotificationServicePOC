package com.demo.microservices.adapterImpl;

import com.demo.microservices.interfaces.NotificationAdapter;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

public class WhatsAppAdapterImpl implements NotificationAdapter {

    public WhatsAppAdapterImpl(){

    }
    @Override
    public void sendNotification(String to, String subject, String content,String countryCode){

        String urlString = "https://api.gupshup.io/sm/api/v1/msg";
        HttpHeaders headers = new HttpHeaders();
        LinkedMultiValueMap<String, Object> request = new LinkedMultiValueMap<>();

        headers.set("Content-Type","application/x-www-form-urlencoded");
        headers.set("apikey","uxeimwg5ew3vndwjr9iukzdxyngagxwp");

        request.add("channel","whatsapp");
        request.add("source","917834811114");
        request.add("destination",countryCode+to);
        request.add("message",content);
        request.add("src.name","TestingDew");

        HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(request, headers);

        RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<String> responseEntity = restTemplate
                  .exchange(urlString, HttpMethod.POST,requestEntity, String.class);
        final String body = responseEntity.getBody();
        System.out.println("response = " + body);

    }
}
