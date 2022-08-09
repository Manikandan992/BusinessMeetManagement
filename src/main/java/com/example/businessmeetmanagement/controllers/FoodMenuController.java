package com.example.businessmeetmanagement.controllers;

import com.example.businessmeetmanagement.dto.FoodMenuDto;
import com.example.businessmeetmanagement.services.FoodMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class FoodMenuController {

    @Autowired
    private FoodMenuService foodMenuService;

    @PostMapping("/addFoodMenu")
    public ResponseEntity<FoodMenuDto> addFoodMenu(@RequestBody FoodMenuDto foodMenu) {
        return ResponseEntity.ok(foodMenuService.addFoodMenu(foodMenu));
    }

    @GetMapping("/foodMenu/{id}")
    public ResponseEntity<FoodMenuDto> getFoodMenu(@PathVariable("id") Integer foodMenuId){
        return ResponseEntity.ok(foodMenuService.getFoodMenu(foodMenuId));
    }

    @GetMapping("/foodMenus")
    public ResponseEntity<List<FoodMenuDto>> getFoodMenus(){
        List<FoodMenuDto> foodMenus=foodMenuService.getFoodMenus();
        return new ResponseEntity<>(foodMenus, HttpStatus.OK);
    }

    @PutMapping("/editFoodMenu/{id}")
    public ResponseEntity<FoodMenuDto> updateFoodMenu(@PathVariable("id") int foodMenuId,@RequestBody FoodMenuDto foodMenu){
        return ResponseEntity.ok(foodMenuService.updateFoodMenu(foodMenuId,foodMenu));
    }

    @DeleteMapping("/deleteFoodMenu/{id}")
    public void deleteFoodMenu(@PathVariable("id") int foodMenuId){ foodMenuService.deleteFoodMenu(foodMenuId);
    }
}
