package com.example.businessmeetmanagement.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foodMenuId;
    private String foodMenuName;
    private String foodMenuImageUrl;
    private long foodMenuPrice;
    private String itemCategory;
}

