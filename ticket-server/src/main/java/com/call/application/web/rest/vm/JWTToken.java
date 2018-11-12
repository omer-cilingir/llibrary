package com.call.application.web.rest.vm;

import com.call.application.security.jwt.JWTConfigurer;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Object to return as body in JWT Authentication.
 */
public class JWTToken {

    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @JsonProperty(JWTConfigurer.AUTHORIZATION_HEADER)
    public String getToken() {
        return token;
    }

}
