package com.example.BrandPlusRegistrationService.model;

import com.example.BrandPlusRegistrationService.model.AuthenticationApiResponse.AuthenticationApiData;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
@Accessors(chain = true)
public class AuthResponse {
    AuthenticationApiData data;

    String userId;

    public String getBusinessId() {
        return data.getBusinessId();
    }
}
