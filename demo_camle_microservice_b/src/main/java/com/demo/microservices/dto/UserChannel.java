package com.demo.microservices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection= "user_channel")
public class UserChannel {
     private String userID;
     private String country;
     private String countryCode;
     private String username;
     List<Channel> channels;
}
