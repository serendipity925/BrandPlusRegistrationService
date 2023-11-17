package com.example.BrandPlusRegistrationService.model.exception;

import com.fasterxml.jackson.core.JsonProcessingException;

public class InvalidJsonException extends JsonProcessingException {
    public InvalidJsonException(String message) {
        super(message);
    }
}
