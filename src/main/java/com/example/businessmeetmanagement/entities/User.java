package com.example.businessmeetmanagement.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String emailId;
    private String name;
    private String phoneNumber;
    private String username;
    private String password;
    private String role ;
}
