package com.businessmeetmanagement.BusinessMeetManagement.controllers;

import com.businessmeetmanagement.BusinessMeetManagement.models.FoodMenu;
import com.businessmeetmanagement.BusinessMeetManagement.services.FoodMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/FoodMenu")
public class FoodMenuController {

    @Autowired
    private FoodMenuService foodMenuService;

    @PostMapping("/addFoodMenu")
    public ResponseEntity<FoodMenu> addFoodMenu(@RequestBody FoodMenu foodMenu) {
        return ResponseEntity.ok(foodMenuService.addFoodMenu(foodMenu));
    }

    @GetMapping("/getFoodMenu/{foodMenuId}")
    public ResponseEntity<FoodMenu> getFoodMenu(@PathVariable("foodMenuId") Integer foodMenuId){
        return ResponseEntity.ok(foodMenuService.getFoodMenu(foodMenuId));
    }

    @GetMapping("/getFoodMenus")
    public ResponseEntity<List<FoodMenu>> getFoodMenus(){
        List<FoodMenu> foodMenus=foodMenuService.getFoodMenus();
        return new ResponseEntity<>(foodMenus, HttpStatus.OK);
    }

    @PutMapping("/editFoodMenu/{foodMenuId}")
    public ResponseEntity<FoodMenu> updateFoodMenu(@PathVariable("foodMenuId") int foodMenuId,@RequestBody FoodMenu foodMenu){
        return ResponseEntity.ok(foodMenuService.updateFoodMenu(foodMenuId,foodMenu));
    }

    @DeleteMapping("/deleteFoodMenu/{foodMenuId}")
    public void deleteFoodMenu(@PathVariable("foodMenuId") int foodMenuId){ foodMenuService.deleteFoodMenu(foodMenuId);
    }
}
