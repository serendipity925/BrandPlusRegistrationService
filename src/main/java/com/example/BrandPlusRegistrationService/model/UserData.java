package com.example.BrandPlusRegistrationService.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@Component
@Scope("prototype")
@Accessors(chain = true)
public class UserData {
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    private boolean admin;

    private String uuid;

    public UserData(String uuid, String email, String password, boolean admin) {
        this.email = email;
        this.password = password;
        this.admin = admin;
        this.uuid = uuid;
    }

}
