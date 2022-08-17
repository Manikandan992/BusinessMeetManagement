package com.example.businessmeetmanagement.services.impl;

import com.example.businessmeetmanagement.dto.ThemeDto;
import com.example.businessmeetmanagement.exceptions.ResourceNotFoundException;
import com.example.businessmeetmanagement.mapper.ThemeMapper;
import com.example.businessmeetmanagement.entities.Theme;
import com.example.businessmeetmanagement.services.ThemeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.businessmeetmanagement.repositories.ThemeRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class ThemeServiceImpl implements ThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    @Autowired
    private ThemeMapper mapper;

    @Override
    public ThemeDto addTheme(ThemeDto theme) {
        Theme theme1 = mapper.toTheme(theme);
        theme1=themeRepository.save(theme1);
        log.info("New Theme Added");
        return mapper.toThemeDto(theme1);
    }

    @Override
    public ThemeDto getTheme(int id) {
        return mapper.toThemeDto(themeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Theme not found")));
    }

    @Override
    public List<ThemeDto> getThemes() {
        return mapper.toThemeDtos(themeRepository.findAll());
    }

    @Override
    public ThemeDto updateTheme(int id,ThemeDto theme) {
        ThemeDto update=mapper.toThemeDto(themeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Theme not found")));
        update.setThemeName(theme.getThemeName());
        update.setThemeDescription(theme.getThemeDescription());
        update.setThemeCost(theme.getThemeCost());
        update.setThemeImageUrl(theme.getThemeImageUrl());
        Theme theme1 = mapper.toTheme(update);
        theme1=themeRepository.save(theme1);
        log.info("Theme Updated");
        return mapper.toThemeDto(theme1);
    }

    @Override
    public void deleteTheme(int id) {
        themeRepository.deleteById(id);
        log.warn("Theme Deleted");
    }
}
