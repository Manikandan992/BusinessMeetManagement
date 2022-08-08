package com.example.businessmeetmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserRequest {
    private int userId;
    private String name;
    private String emailId;
    private String phoneNumber;
    private String username;
    private String password;
    private List <String> roles;

}
