package com.businessmeetmanagement.BusinessMeetManagement.dto;

import lombok.Data;

@Data
public class FoodMenuDto {
    private int foodMenuId;
    private String foodMenuName;
    private String foodMenuImageUrl;
    private long FoodMenuPrice;
    private String itemCategory;

    //Getters and Setters

    /*public int getFoodMenuId() {
        return foodMenuId;
    }

    public void setFoodMenuId(int foodMenuId) {
        this.foodMenuId = foodMenuId;
    }

    public String getFoodMenuName() {
        return foodMenuName;
    }

    public void setFoodMenuName(String foodMenuName) {
        this.foodMenuName = foodMenuName;
    }

    public String getFoodMenuImageUrl() {
        return foodMenuImageUrl;
    }

    public void setFoodMenuImageUrl(String foodMenuImageUrl) {
        this.foodMenuImageUrl = foodMenuImageUrl;
    }

    public long getFoodMenuPrice() {
        return FoodMenuPrice;
    }

    public void setFoodMenuPrice(long foodMenuPrice) {
        FoodMenuPrice = foodMenuPrice;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }
    public FoodMenuDto(){
        super();
    }*/
}
