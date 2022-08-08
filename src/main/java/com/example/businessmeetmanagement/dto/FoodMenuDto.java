package com.example.businessmeetmanagement.dto;

import lombok.Data;

@Data
public class FoodMenuDto {
    private int foodMenuId;
    private String foodMenuName;
    private String foodMenuImageUrl;
    private long foodMenuPrice;
    private String itemCategory;
}
