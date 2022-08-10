package com.example.businessmeetmanagement.dto;

import lombok.Data;

@Data
public class InvoiceDto {
    private int uThemeId;
    private String customerName;
    private String customerContact;
    private int totalCost;
    private int themeCost;
    private int foodCost;
    private int addonCost;
    private int tax;
}