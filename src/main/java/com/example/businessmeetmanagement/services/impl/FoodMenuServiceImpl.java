package com.example.businessmeetmanagement.services.impl;

import com.example.businessmeetmanagement.dto.FoodMenuDto;
import com.example.businessmeetmanagement.exceptions.ResourceNotFoundException;
import com.example.businessmeetmanagement.mapper.FoodMenuMapper;
import com.example.businessmeetmanagement.entities.FoodMenu;
import com.example.businessmeetmanagement.services.FoodMenuService;
import com.example.businessmeetmanagement.repositories.FoodMenuRepository;
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

    @Autowired
    private FoodMenuMapper mapper;


    @Override
    public FoodMenuDto addFoodMenu(FoodMenuDto foodMenu) {
        FoodMenu foodMenu1=mapper.toFoodMenu(foodMenu);
        foodMenu1=foodMenuRepository.save(foodMenu1);
        log.info("New FoodMenu Created");
        return mapper.toFoodMenuDto(foodMenu1);
    }

    @Override
    public FoodMenuDto getFoodMenu(int foodMenuId) {
        return mapper.toFoodMenuDto(foodMenuRepository.findById(foodMenuId)
                .orElseThrow(()->new ResourceNotFoundException("FoodMenu not found")));
    }

    @Override
    public List<FoodMenuDto> getFoodMenus() {
        return mapper.toFoodMenuDtos(foodMenuRepository.findAll());
    }

    @Override
    public FoodMenuDto updateFoodMenu(int foodMenuId, FoodMenuDto foodMenu) {
        FoodMenuDto update=mapper.toFoodMenuDto(foodMenuRepository.findById(foodMenuId)
                .orElseThrow(()-> new ResourceNotFoundException("FoodMenu not found")));
        update.setFoodMenuName(foodMenu.getFoodMenuName());
        update.setFoodMenuImageUrl(foodMenu.getFoodMenuImageUrl());
        update.setFoodMenuPrice(foodMenu.getFoodMenuPrice());
        update.setItemCategory(foodMenu.getItemCategory());
        FoodMenu foodMenu1=mapper.toFoodMenu(foodMenu);
        foodMenu1=foodMenuRepository.save(foodMenu1);
        log.info("FoodMenu updated");
        return mapper.toFoodMenuDto(foodMenu1);
    }

    @Override
    public void deleteFoodMenu(int foodMenuId) {
        foodMenuRepository.deleteById(foodMenuId);
        log.warn("FoodMenu Deleted");
    }

}
