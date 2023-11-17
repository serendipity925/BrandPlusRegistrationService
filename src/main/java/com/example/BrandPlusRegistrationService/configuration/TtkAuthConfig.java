package com.example.BrandPlusRegistrationService.configuration;

import com.example.BrandPlusRegistrationService.model.AuthenticationApiResponse.AuthRequest;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TtkAuthConfig {
    @Bean
    @ConfigurationProperties(prefix="tiktok-auth")
    public AuthConfig getAuthConfig(){
        return new AuthConfig();
    }

    @Data
    public static class AuthConfig{
        private String clientId;
        private String clientSecret;
        private String grantTypeAuthCode;
        private String redirectUri;
        private String endPoint;
        private String grantTypeRefToken;


        public AuthRequest getAuthRequest() {
            AuthRequest authRequest = new AuthRequest();
            authRequest.setClientId(clientId);
            authRequest.setClientSecret(clientSecret);
            authRequest.setGrantType(grantTypeAuthCode);
            authRequest.setRedirect_uri(redirectUri);
            authRequest.setEndPoint(endPoint);
            return authRequest;
        }

    }
}
