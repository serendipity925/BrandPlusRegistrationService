package com.example.BrandPlusRegistrationService.model.RefreshApiResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RefRequest {
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
    @JsonProperty("refresh_token")
    private String refToken;
    @NotBlank
    @JsonProperty("redirect_uri")
    private String redirect_uri;
    @NotBlank
    private String endPoint;

}
