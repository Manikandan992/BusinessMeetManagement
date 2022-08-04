package com.businessmeetmanagement.BusinessMeetManagement.services.impl;

import com.businessmeetmanagement.BusinessMeetManagement.exceptions.ResourceNotFoundException;
import com.businessmeetmanagement.BusinessMeetManagement.models.Theme;
import com.businessmeetmanagement.BusinessMeetManagement.repositories.ThemeRepository;
import com.businessmeetmanagement.BusinessMeetManagement.services.ThemeService;
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

    @Override
    public Theme addTheme(Theme theme) {
        log.info("New Theme Added");
        return themeRepository.save(theme);
    }

    @Override
    public Theme getTheme(int themeId) {
        return themeRepository.findById(themeId)
                .orElseThrow(()->new ResourceNotFoundException("Theme not found"));
    }

    @Override
    public List<Theme> getThemes() {
        return themeRepository.findAll();
    }

    @Override
    public Theme updateTheme(int themeId,Theme theme) {
        Theme update=themeRepository.findById(themeId).orElseThrow(()->new ResourceNotFoundException("Theme not found"));
        update.setThemeName(theme.getThemeName());
        update.setThemeDescription(theme.getThemeDescription());
        update.setThemePhotographer(theme.getThemePhotographer());
        update.setThemeVideographer(theme.getThemeVideographer());
        update.setThemeCost(theme.getThemeCost());
        update.setThemeImageUrl(theme.getThemeImageUrl());
        update.setThemeReturnGift(theme.getThemeReturnGift());
        log.info("Theme Updated");
        return themeRepository.save(update);
    }

    @Override
    public void deleteTheme(int themeId) {
        themeRepository.deleteById(themeId);
        log.warn("Theme Deleted");
    }
}
