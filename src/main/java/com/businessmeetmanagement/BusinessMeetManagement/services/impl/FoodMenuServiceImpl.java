package com.businessmeetmanagement.BusinessMeetManagement.services.impl;

import com.businessmeetmanagement.BusinessMeetManagement.exceptions.ResourceNotFoundException;
import com.businessmeetmanagement.BusinessMeetManagement.models.FoodMenu;
import com.businessmeetmanagement.BusinessMeetManagement.repositories.FoodMenuRepository;
import com.businessmeetmanagement.BusinessMeetManagement.services.FoodMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j

public class FoodMenuServiceImpl implements FoodMenuService {

    @Autowired
    private FoodMenuRepository foodMenuRepository;


    @Override
    public FoodMenu addFoodMenu(FoodMenu foodMenu) {
        log.info("New FoodMenu Created");
        return foodMenuRepository.save(foodMenu);
    }

    @Override
    public FoodMenu getFoodMenu(int foodMenuId) {
        return foodMenuRepository.findById(foodMenuId).orElseThrow(()->new ResourceNotFoundException("FoodMenu not found"));
    }

    @Override
    public List<FoodMenu> getFoodMenus() {
        return foodMenuRepository.findAll();
    }

    @Override
    public FoodMenu updateFoodMenu(int foodMenuId, FoodMenu foodMenu) {
        FoodMenu update=foodMenuRepository.findById(foodMenuId).orElseThrow(()-> new ResourceNotFoundException("FoodMenu not found"));
        update.setFoodMenuName(foodMenu.getFoodMenuName());
        update.setFoodMenuImageUrl(foodMenu.getFoodMenuImageUrl());
        update.setFoodMenuPrice(foodMenu.getFoodMenuPrice());
        update.setItemCategory(foodMenu.getItemCategory());
        log.info("FoodMenu updated");
        return foodMenuRepository.save(update);
    }

    @Override
    public void deleteFoodMenu(int foodMenuId) {
        foodMenuRepository.deleteById(foodMenuId);
        log.warn("FoodMenu Deleted");

    }

}
