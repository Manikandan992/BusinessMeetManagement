package com.example.businessmeetmanagement.services;

import com.example.businessmeetmanagement.dto.FoodMenuDto;
import com.example.businessmeetmanagement.models.FoodMenu;

import java.util.List;

public interface FoodMenuService {
    FoodMenuDto addFoodMenu(FoodMenuDto foodMenu);
    FoodMenuDto getFoodMenu(int foodMenuId);
    List<FoodMenuDto> getFoodMenus();
    FoodMenuDto updateFoodMenu(int foodMenuId,FoodMenuDto foodMenu);
    void deleteFoodMenu(int foodMenuId);
}
