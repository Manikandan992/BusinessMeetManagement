package com.example.businessmeetmanagement.services;

import com.example.businessmeetmanagement.entities.User;
import com.example.businessmeetmanagement.model.UserRequest;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserAuthenticationServices {
    UserDetails loadUserByUsername(String username);
    void registerUser(UserRequest userRequest);
    User getUserById(int userId);
    User getUserByUserName(String userName);
}