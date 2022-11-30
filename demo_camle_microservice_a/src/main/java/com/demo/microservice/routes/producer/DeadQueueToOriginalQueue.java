package com.demo.microservice.routes.producer;


import com.demo.microservice.dto.ChannelProviders;

import com.demo.microservice.dto.Notification;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//@Component
public class DeadQueueToOriginalQueue extends RouteBuilder {


    @Override
    public void configure() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        List<ChannelProviders>channels=new ArrayList<>();
        channels.add(new ChannelProviders("email","XYZ"," Resolve_sms_provider_123xyz","1"));
        LocalDateTime lt
                = LocalDateTime.now();



        from("{{dead.exchange.uri}}")
                .setBody(constant(mapper.writeValueAsString(
                        new Notification("Rezolve_system_01_D0A40BC8-F84C-4B2C-97B4-C3C1B1E31BC7"+5,
                                "Rezolve_system_01", "garima.sharma513@gmail.com", "return_url",
                                "UK", "Rezolve_email_checkout_v1_en", "Email", "1", "en",
                                lt, lt,channels)

                )))
                .to("{{original.exchange.return.uri}}");

        from("{{duplicate.exchange.uri}}")

                .to("log:duplicatequeue")
                .to("{{write.to.original}}")

                .to("log:myLoggingQueue")
                .to("log:data wright to original queue");
    }
}
