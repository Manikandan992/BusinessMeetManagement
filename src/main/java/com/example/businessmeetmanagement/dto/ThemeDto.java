package com.example.businessmeetmanagement.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThemeDto {
    private int id;
    private String themeName;
    private String themeImageUrl;
    private String themeDescription;
    private long themeCost;
}
