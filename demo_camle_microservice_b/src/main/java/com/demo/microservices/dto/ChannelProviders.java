package com.demo.microservices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ChannelProviders {

    private String type;
    private String providerName;
    private String providerId;
    private String priority;

}
