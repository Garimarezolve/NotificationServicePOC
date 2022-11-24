package com.demo.microservice.dto;

import com.demo.microservice.dto.Channel;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserChannel {
     private String userID;
     private String country;
     private String countryCode;
     private String username;
     List<Channel> channels;
}
