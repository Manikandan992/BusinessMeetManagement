package com.example.businessmeetmanagement.services.impl;

import com.example.businessmeetmanagement.dto.ThemeDto;
import com.example.businessmeetmanagement.exceptions.ResourceNotFoundException;
import com.example.businessmeetmanagement.mapper.ThemeMapper;
import com.example.businessmeetmanagement.models.Theme;
import com.example.businessmeetmanagement.repositories.ThemeRepository;
import com.example.businessmeetmanagement.services.ThemeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ThemeDto getTheme(int themeId) {
        return mapper.toThemeDto(themeRepository.findById(themeId)
                .orElseThrow(()->new ResourceNotFoundException("Theme not found")));
    }

    @Override
    public List<ThemeDto> getThemes() {
        return mapper.toThemeDtos(themeRepository.findAll());
    }

    @Override
    public ThemeDto updateTheme(int themeId,ThemeDto theme) {
        ThemeDto update=mapper.toThemeDto(themeRepository.findById(themeId)
                .orElseThrow(()->new ResourceNotFoundException("Theme not found")));
        update.setThemeName(theme.getThemeName());
        update.setThemeDescription(theme.getThemeDescription());
        update.setThemePhotographer(theme.getThemePhotographer());
        update.setThemeVideographer(theme.getThemeVideographer());
        update.setThemeCost(theme.getThemeCost());
        update.setThemeImageUrl(theme.getThemeImageUrl());
        update.setThemeReturnGift(theme.getThemeReturnGift());
        Theme theme1 = mapper.toTheme(update);
        theme1=themeRepository.save(theme1);
        log.info("Theme Updated");
        return mapper.toThemeDto(theme1);
    }

    @Override
    public void deleteTheme(int themeId) {
        themeRepository.deleteById(themeId);
        log.warn("Theme Deleted");
    }
}
