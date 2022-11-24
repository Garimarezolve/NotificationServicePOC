package com.demo.microservices.dto;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "user_channel")
public class UserChannel {
//	@Id
//	private String id;
	private String userID;
	private String country;
	private String countryCode;
	private String username;
	List<Channel> channels;
}
