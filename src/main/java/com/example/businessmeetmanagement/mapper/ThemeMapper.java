package com.example.businessmeetmanagement.mapper;

import com.example.businessmeetmanagement.dto.ThemeDto;
import com.example.businessmeetmanagement.entities.Theme;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ThemeMapper {

    public Theme toTheme(ThemeDto themeDto){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(themeDto,Theme.class);
    }

    public ThemeDto toThemeDto(Theme theme){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(theme,ThemeDto.class);
    }

    public List<ThemeDto> toThemeDtos(List<Theme> themes){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return Arrays.asList(mapper.map(themes,ThemeDto[].class));
    }
}
