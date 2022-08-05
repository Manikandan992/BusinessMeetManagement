package com.example.businessmeetmanagement.services.impl;

import com.example.businessmeetmanagement.model.UserRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.example.businessmeetmanagement.services;

public class UserAuthenticationServices implements UserAuthenticationServices, UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) {
        return null;
    }

    @Override
    public void registerUser(UserRequest userRequest) {

    }
}
