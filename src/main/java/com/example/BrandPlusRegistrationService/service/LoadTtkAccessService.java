package com.example.BrandPlusRegistrationService.service;

import com.example.BrandPlusRegistrationService.configuration.TtkAuthConfig;
import com.example.BrandPlusRegistrationService.configuration.TtkRefConfig;
import com.example.BrandPlusRegistrationService.model.AuthResponse;
import com.example.BrandPlusRegistrationService.model.AuthenticationApiResponse.AuthRequest;
import com.example.BrandPlusRegistrationService.model.AuthenticationApiResponse.AuthenApiResponse;
import com.example.BrandPlusRegistrationService.model.RefreshApiResponse.RefRequest;
import com.example.BrandPlusRegistrationService.repository.TtkAuthMyBatisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;

/**
 *
 */
@Service
@Validated
public class LoadTtkAccessService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private TtkAuthConfig.AuthConfig authConfig;

    @Autowired
    private TtkRefConfig.RefConfig refConfig;

    @Autowired
    private AuthResponse response;

    @Autowired
    private TtkAuthMyBatisRepository ttkAuthRepository;

    @Autowired
    private LoadTtkAuthDBService loadTtkAuthDBService;

    @Autowired
    private TokenTimeStampService expTimeService;

    //use for dummy user
    public AuthResponse loadAccessByAuthCode(String authCode) {
        AuthRequest authRequest = authConfig.getAuthRequest();
        authRequest.setAuthCode(authCode);
        HttpEntity<AuthRequest> request = new HttpEntity<>(authRequest);
        response.setData(restTemplate.postForEntity(authConfig.getEndPoint(), request, AuthenApiResponse.class).getBody().getData());
        response.setUserId("test_id");
        expTimeService.convertTokenExpDate(response);
        loadTtkAuthDBService.saveOrUpdateAuthData(response.getData());

        return response;
    }

    //use for dummy user
    public AuthResponse loadAccessByRefToken(String refToken) {
        RefRequest refRequest = refConfig.getRefRequest();
        refRequest.setRefToken(refToken);
        HttpEntity<RefRequest> request = new HttpEntity<>(refRequest);
        response.setData(restTemplate.postForEntity(refConfig.getEndPoint(), request, AuthenApiResponse.class).getBody().getData());
        response.setUserId("test_id2");
        expTimeService.convertTokenExpDate(response);
        loadTtkAuthDBService.saveOrUpdateAuthData(response.getData());


        return response;
    }

    //use for real user
    public boolean loadAccessByAuth(String authCode, String email) {
        AuthRequest authRequest = authConfig.getAuthRequest();
        authRequest.setAuthCode(authCode);
        HttpEntity<AuthRequest> request = new HttpEntity<>(authRequest);
        response.setData(restTemplate.postForEntity(authConfig.getEndPoint(), request, AuthenApiResponse.class).getBody().getData());
        response.setUserId(email);
        expTimeService.convertTokenExpDate(response);
        loadTtkAuthDBService.saveOrUpdateAuth(response);

        return true;
    }

    //use for real user
    public AuthResponse loadAccessByRef(String refToken, String email) {
        RefRequest refRequest = refConfig.getRefRequest();
        refRequest.setRefToken(refToken);
        HttpEntity<RefRequest> request = new HttpEntity<>(refRequest);
        response.setData(restTemplate.postForEntity(refConfig.getEndPoint(), request, AuthenApiResponse.class).getBody().getData());
        response.setUserId(email);
        expTimeService.convertTokenExpDate(response);
        loadTtkAuthDBService.saveOrUpdateAuthData(response.getData());

        return response;
    }



}