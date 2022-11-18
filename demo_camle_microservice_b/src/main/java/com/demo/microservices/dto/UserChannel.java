package com.demo.microservices.dto;

import com.demo.microservices.dto.Channel;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserChannel {
     private String userID;
     private String country;
     private String countryCode;
     private String username;
     List<Channel> channels;
}
