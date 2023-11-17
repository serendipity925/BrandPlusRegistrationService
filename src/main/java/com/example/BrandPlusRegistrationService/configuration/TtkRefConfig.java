package com.example.BrandPlusRegistrationService.configuration;

import com.example.BrandPlusRegistrationService.model.RefreshApiResponse.RefRequest;
import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TtkRefConfig {
    @Bean
    @ConfigurationProperties(prefix="tiktok-ref")
    public RefConfig getRefConfig(){
        return new RefConfig();
    }

    @Data
    public static class RefConfig{
        private String clientId;
        private String clientSecret;
        private String grantTypeRefToken;
        private String endPoint;


        public RefRequest getRefRequest() {
            RefRequest refRequest = new RefRequest();
            refRequest.setClientId(clientId)
                    .setClientSecret(clientSecret)
                    .setGrantType(grantTypeRefToken)
                    .setEndPoint(endPoint);
            return refRequest;
        }

    }
}
