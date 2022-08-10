package com.example.businessmeetmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AuthenticationRequest {
    private String emailId;
    private String password;
    private String role;

}
