package com.example.BrandPlusRegistrationService.service;

import com.example.BrandPlusRegistrationService.model.UserData;
import com.example.BrandPlusRegistrationService.repository.AccountInfoMyBatisRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BrandPlusSignUpService {

    @Autowired
    private AccountInfoMyBatisRepository accountInfoMyBatisRepository;


    private final PasswordEncoder passwordEncoder = new Argon2PasswordEncoder(16,32,8,65536,4);

    public boolean insertAccountInfo(@NotNull UserData userData){
        try {
            String hashedPassword = passwordEncoder.encode(userData.getPassword());
            userData.setPassword(hashedPassword);
            accountInfoMyBatisRepository.insert(userData);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean updateAccountInfo(@NotBlank String uuid, @NotBlank String password){
        try {
            String hashedPassword = passwordEncoder.encode(password);
            accountInfoMyBatisRepository.updatePassword(uuid,hashedPassword);
            return true;
        }catch (Exception e){
            return false;
        }
    }


    public String checkAccountInfo(String email, String password){
        UserData storedData = accountInfoMyBatisRepository.findByEmail(email);
        if(storedData == null){
            return null;
        }
        if(passwordEncoder.matches(password, storedData.getPassword())){
           return storedData.getUuid();
        }
        return null;
    }
}
