package com.example.BrandPlusRegistrationService.model.AuthenticationApiResponse;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"description", "access_token", "expires_in", "open_id","refresh_token",
        "refresh_token_expires_in","scope","token_type"})
public class AuthenticationData extends AuthenticationApiData{
    public String description = "Hello this is Authentication description!";
    public AuthenticationData(AuthenticationApiData apiData){
        super();
        this.setAccessToken(apiData.getAccessToken());
        this.setExpiresIn(apiData.getExpiresIn());
        this.setScope(apiData.getScope());
        this.setRefreshToken(apiData.getRefreshToken());
        this.setRefreshTokenExpiresIn(apiData.getRefreshTokenExpiresIn());
        this.setTokenType(apiData.getTokenType());
        this.setBusinessId(apiData.getBusinessId());
    }
}
