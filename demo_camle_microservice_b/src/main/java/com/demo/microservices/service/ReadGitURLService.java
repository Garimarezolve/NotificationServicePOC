package com.demo.microservices.service;

import org.springframework.scheduling.annotation.Async;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;


public class ReadGitURLService {

    @Async
    public void readFileURL() throws IOException {
            String singleUrl = "https://raw.githubusercontent.com/Garimarezolve/NotificationServicePOC/test/templates/email.mustache";
            String fileUrl="/home/garimas/Documents/ApacheCamelDemoProjct/demo_camle_microservice_b/src/main/resources/templates/email.mustache";
            downloadUsingNIO(singleUrl,  fileUrl);
        }
    private static void downloadUsingNIO(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

        fos.close();
        rbc.close();
    }



}
