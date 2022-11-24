package com.demo.microservice.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Notification {

	private String notifcationId;
	private String senderId;
	private String receipientEmail;
	private String returnUrl;
	private String country;
	private String templateId;
	private String channelType;
	private String notificationPriority;
	private String language;

	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime createdAt;
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime updateAt;
	List<ChannelProviders> channelProviders;
}
