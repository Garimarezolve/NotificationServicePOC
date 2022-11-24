package com.demo.microservices.dto;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "notification_channel")
public class Notification {
	
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
	List<ChannelProviders> channelProviders;
}
