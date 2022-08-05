package com.example.businessmeetmanagement.repositories;

import com.example.businessmeetmanagement.entities.FoodMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodMenuRepository extends JpaRepository<FoodMenu,Integer>  {
}
