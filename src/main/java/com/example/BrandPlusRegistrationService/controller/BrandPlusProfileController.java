package com.example.BrandPlusRegistrationService.controller;

import com.example.BrandPlusRegistrationService.model.ProfileData;
import com.example.BrandPlusRegistrationService.repository.RetrieveAccDataMyBatisRepository;
import com.example.BrandPlusRegistrationService.service.LoadProfileDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@CrossOrigin
public class BrandPlusProfileController {

    @Autowired
    private LoadProfileDataService loadProfileDataService;

    @GetMapping("/profile")
    public ProfileData resetPassword(@RequestParam String uuid){
        return loadProfileDataService.loadProfile(uuid);
    }
}
