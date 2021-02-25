package com.spp.gym_network.mainservice.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "gym-service")
@Getter
@Setter
public class GymServiceProperties {
    private String secureTokenValidity;
    private String baseUrlHttp;
    private String baseUrlHttps;
    private String jwtSecret;
    private int jwtExpirationInMs;
}
