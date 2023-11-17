package com.example.BrandPlusRegistrationService.model.AuthenticationApiResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"access_token","expires_in","open_id","refresh_token",
        "refresh_token_expires_in","scope","token_type"})
public class AuthenticationApiData {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private Long expiresIn;

    @JsonProperty("open_id")
    private String businessId; // open_id = creator_id = open_id

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("refresh_token_expires_in")
    private Long refreshTokenExpiresIn;

    private String scope;

    @JsonProperty("token_type")
    private String tokenType;

}
