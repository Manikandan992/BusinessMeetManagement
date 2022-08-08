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
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int themeId;
    private String themeName;
    private String themeImageUrl;
    private String themeDescription;
    private String themePhotographer;
    private String themeVideographer;
    private String themeReturnGift;
    private long themeCost;
}
