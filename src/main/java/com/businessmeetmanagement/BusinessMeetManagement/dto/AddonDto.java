package com.businessmeetmanagement.BusinessMeetManagement.dto;

import lombok.Data;

@Data
public class AddonDto {
    private int addonId;
    private String addonName;
    private String addonDescription;
    private long addonPrice;

    //Getters and Setters

    /*public int getAddonId() {
        return addonId;
    }

    public void setAddonId(int addonId) {
        this.addonId = addonId;
    }

    public String getAddonName() {
        return addonName;
    }

    public void setAddonName(String addonName) {
        this.addonName = addonName;
    }

    public String getAddonDescription() {
        return addonDescription;
    }

    public void setAddonDescription(String addonDescription) {
        this.addonDescription = addonDescription;
    }

    public long getAddonPrice() {
        return addonPrice;
    }

    public void setAddonPrice(long addonPrice) {
        this.addonPrice = addonPrice;
    }
    public AddonDto() {
        super();
    } */
}
