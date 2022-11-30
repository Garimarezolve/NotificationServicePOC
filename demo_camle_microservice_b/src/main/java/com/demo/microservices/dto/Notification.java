package com.demo.microservices.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "notification_channel")
public class Notification {
    List<ChannelProviders> channelProviders;
    @Id
    private String id;
    private String notifcationId;
    private String senderId;
    private String receipientEmail;
    private String returnUrl;
    private String country;
    private String templateId;
    private String language;
    private String notificationPriority;
    private String channelType;
    private boolean isProcess;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdAt;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updateAt;
}
