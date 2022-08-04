package com.businessmeetmanagement.BusinessMeetManagement.services;

import com.businessmeetmanagement.BusinessMeetManagement.models.FoodMenu;

import java.util.List;

public interface FoodMenuService {
    FoodMenu addFoodMenu(FoodMenu foodMenu);
    FoodMenu getFoodMenu(int foodMenuId);
    List<FoodMenu> getFoodMenus();
    FoodMenu updateFoodMenu(int foodMenuId,FoodMenu foodMenu);
    void deleteFoodMenu(int foodMenuId);
}
