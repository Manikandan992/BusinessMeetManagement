package com.example.businessmeetmanagement.dto;

import lombok.Data;

@Data
public class ThemeDto {
    private int themeId;
    private String themeName;
    private String themeImageUrl;
    private String themeDescription;
    private String themePhotographer;
    private String themeVideographer;
    private String themeReturnGift;
    private long themeCost;
}
