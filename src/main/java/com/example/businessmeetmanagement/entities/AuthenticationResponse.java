package com.example.businessmeetmanagement.entities;

import com.example.businessmeetmanagement.dto.UserDto;

public class AuthenticationResponse {
    private final String jwt;
    private UserDto user;

    public AuthenticationResponse(String jwt, UserDto user) {
        this.jwt = jwt;
        this.user = user;
    }

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;

    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }
}
