package com.example.BrandPlusRegistrationService.service;

import com.example.BrandPlusRegistrationService.repository.RetrieveAccDataMyBatisRepository;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoadTtkHealthTrackerService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RetrieveAccDataMyBatisRepository repository;
    public void LoadTtkHealthTracker(@NotBlank String uuid){
        String accessToken = repository.getTtkAccessToken(uuid);
        String businessId = repository.getTtkBusinessId(uuid);
        String url = "http://localhost:8082/loadTtkData/SixtyMetric?accessToken=" + accessToken + "&businessId=" + businessId;
        String response = restTemplate.getForObject(url, String.class);
        System.out.println(response);
    }
}
