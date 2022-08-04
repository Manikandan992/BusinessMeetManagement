package com.businessmeetmanagement.BusinessMeetManagement.dto;

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

    //Getters and Setters

    /*public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getThemeImageUrl() {
        return themeImageUrl;
    }

    public void setThemeImageUrl(String themeImageUrl) {
        this.themeImageUrl = themeImageUrl;
    }

    public String getThemeDescription() {
        return themeDescription;
    }

    public void setThemeDescription(String themeDescription) {
        this.themeDescription = themeDescription;
    }

    public String getThemePhotographer() {
        return themePhotographer;
    }

    public void setThemePhotographer(String themePhotographer) {
        this.themePhotographer = themePhotographer;
    }

    public String getThemeVideographer() {
        return themeVideographer;
    }

    public void setThemeVideographer(String themeVideographer) {
        this.themeVideographer = themeVideographer;
    }

    public String getThemeReturnGift() {
        return themeReturnGift;
    }

    public void setThemeReturnGift(String themeReturnGift) {
        this.themeReturnGift = themeReturnGift;
    }

    public long getThemeCost() {
        return themeCost;
    }

    public void setThemeCost(long themeCost) {
        this.themeCost = themeCost;
    }
    public ThemeDto() {
        super();
    } */
}
