package com.example.BrandPlusRegistrationService.service;

import com.example.BrandPlusRegistrationService.model.AuthResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TokenTimeStampService {
    public void convertTokenExpDate(@NotNull AuthResponse response){
        long accessExpTime = Instant.now().getEpochSecond() + response.getData().getExpiresIn();
        long refExpTime = Instant.now().getEpochSecond() + response.getData().getRefreshTokenExpiresIn();
        response.getData().setExpiresIn(accessExpTime);
        response.getData().setRefreshTokenExpiresIn(refExpTime);
    }
}
