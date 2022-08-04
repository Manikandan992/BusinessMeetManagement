package com.example.businessmeetmanagement.services;

import com.example.businessmeetmanagement.dto.ThemeDto;

import java.util.List;

public interface ThemeService {
    ThemeDto addTheme(ThemeDto theme);
    ThemeDto getTheme(int themeId);
    List<ThemeDto> getThemes();
    ThemeDto updateTheme(int themeId,ThemeDto theme);
    void deleteTheme(int themeId);
}
