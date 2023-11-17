package com.example.BrandPlusRegistrationService.model.AuthenticationApiResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AuthRequest {
    @NotBlank
    @JsonProperty("client_id")
    private String clientId;
    @NotBlank
    @JsonProperty("client_secret")
    private String clientSecret;
    @NotBlank
    @JsonProperty("grant_type")
    private String grantType;
    @NotBlank
    @JsonProperty("auth_code")
    private String authCode;
    @NotBlank
    @JsonProperty("redirect_uri")
    private String redirect_uri;
    @NotBlank
    private String endPoint;



}