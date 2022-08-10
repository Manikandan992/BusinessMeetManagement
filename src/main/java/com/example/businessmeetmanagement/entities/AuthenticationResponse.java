package com.example.businessmeetmanagement.entities;

public class AuthenticationResponse {
    private final String jwt;
    private User user;

    public AuthenticationResponse(String jwt, User user) {
        this.jwt = jwt;
        this.user = user;
    }

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
