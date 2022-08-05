package com.example.businessmeetmanagement.mapper;

import com.example.businessmeetmanagement.dto.AddonDto;
import com.example.businessmeetmanagement.entities.Addon;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AddonMapper {
    public Addon toAddon(AddonDto addonDto){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(addonDto,Addon.class);
    }

    public AddonDto toAddonDto(Addon addon){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(addon,AddonDto.class);
    }

    public List<AddonDto> toAddonDtos(List<Addon> addons){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return Arrays.asList(mapper.map(addons,AddonDto[].class));
    }
}
