package com.example.BrandPlusRegistrationService.service;

import com.example.BrandPlusRegistrationService.model.AuthResponse;
import com.example.BrandPlusRegistrationService.model.AuthenticationApiResponse.AuthenticationApiData;
import com.example.BrandPlusRegistrationService.repository.TtkAuthMyBatisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class LoadTtkAuthDBService {
    @Autowired
    private TtkAuthMyBatisRepository ttkAuthRepository;


    // Test for dummy user
    public void saveOrUpdateAuthData(AuthenticationApiData authData) {
        if (ttkAuthRepository.countByBusinessId(authData.getBusinessId(),"test_id") > 0) {
            ttkAuthRepository.updateAccessToken(authData,"test_id");
        } else {
            ttkAuthRepository.insert(authData,"test_id");
        }
    }



    //use for real user
    public void saveOrUpdateAuth(AuthResponse authData) {
        if (ttkAuthRepository.countByBusinessId(authData.getData().getBusinessId(), authData.getUserId()) > 0) {
            ttkAuthRepository.updateAccessToken(authData.getData(), authData.getUserId());
        } else {
            ttkAuthRepository.insert(authData.getData(), authData.getUserId());
        }
    }
}
