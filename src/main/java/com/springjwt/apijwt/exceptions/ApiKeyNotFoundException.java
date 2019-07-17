package com.springjwt.apijwt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApiKeyNotFoundException extends RuntimeException {
    public ApiKeyNotFoundException() {
        super(" ApiKey not present: " );
    }
}