package com.example.businessmeetmanagement.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private long id;
    private String usertype;
    private String  email;
    private String name;
    private String phone;
    private String password;
}
