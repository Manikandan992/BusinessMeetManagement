package com.example.businessmeetmanagement.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uThemeId;
    private String customerName;
    private String customerContact;
    private int totalCost;
    private int uThemeCost;
    private int foodCost;
    private int addonCost;
    private int tax;
}
