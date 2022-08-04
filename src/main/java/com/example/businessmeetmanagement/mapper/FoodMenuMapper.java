package com.example.businessmeetmanagement.mapper;

import com.example.businessmeetmanagement.dto.FoodMenuDto;
import com.example.businessmeetmanagement.models.FoodMenu;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class FoodMenuMapper {
    public FoodMenu toFoodMenu(FoodMenuDto foodMenuDto){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(foodMenuDto,FoodMenu.class);
    }

    public FoodMenuDto toFoodMenuDto(FoodMenu foodMenu){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(foodMenu,FoodMenuDto.class);
    }

    public List<FoodMenuDto> toFoodMenuDtos(List<FoodMenu> foodMenus){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return Arrays.asList(mapper.map(foodMenus,FoodMenuDto[].class));
    }
}
