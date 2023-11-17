package com.example.BrandPlusRegistrationService.controller;

import com.example.BrandPlusRegistrationService.model.AuthResponse;
import com.example.BrandPlusRegistrationService.model.UserData;
import com.example.BrandPlusRegistrationService.service.BrandPlusSignUpService;
import com.example.BrandPlusRegistrationService.service.LoadTtkAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loadAccess")
public class LoadTtkAccessController {
    @Autowired
    private LoadTtkAccessService accessService;

    @GetMapping("/Auth")
    public AuthResponse loadAccessByAuthCode(@RequestParam String authCode) {
        return accessService.loadAccessByAuthCode(authCode);
    }

    @GetMapping("/RefToken")
    public AuthResponse loadAccessByRefToken(@RequestParam String refToken) {
        return accessService.loadAccessByRefToken(refToken);
    }

}
