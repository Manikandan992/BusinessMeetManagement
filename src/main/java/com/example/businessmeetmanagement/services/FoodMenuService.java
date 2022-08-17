package com.example.businessmeetmanagement.services;

import com.example.businessmeetmanagement.dto.FoodMenuDto;

import java.util.List;

public interface FoodMenuService {
    FoodMenuDto addFoodMenu(FoodMenuDto foodMenu);
    FoodMenuDto getFoodMenu(int id);
    List<FoodMenuDto> getFoodMenus();
    FoodMenuDto updateFoodMenu(int id,FoodMenuDto foodMenu);
    void deleteFoodMenu(int id);
}
