package com.example.BrandPlusRegistrationService.model.AuthenticationApiResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"code","message","request_id","data"})
public class AuthenApiResponse {
    private Integer code;
    private String message;

    @JsonProperty("request_id")
    private String requestId;

    private AuthenticationApiData data;
}
