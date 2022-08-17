package com.example.businessmeetmanagement.dto;

import lombok.Data;

@Data
public class UserDto {
    private long id;
    private String usertype;
    private String  email;
    private String name;
    private String phone;
    private String password;
}
