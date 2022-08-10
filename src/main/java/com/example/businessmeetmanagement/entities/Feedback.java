package com.example.businessmeetmanagement.entities;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    private int userId;
    private String rating;
    private String review;
}
