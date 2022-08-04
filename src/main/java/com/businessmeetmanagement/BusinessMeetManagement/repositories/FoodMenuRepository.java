package com.businessmeetmanagement.BusinessMeetManagement.repositories;

import com.businessmeetmanagement.BusinessMeetManagement.models.FoodMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodMenuRepository extends JpaRepository<FoodMenu,Integer>  {
}
