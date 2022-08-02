package com.businessmeetmanagement.BusinessMeetManagement.services;

import com.businessmeetmanagement.BusinessMeetManagement.models.Theme;

import java.util.List;

public interface ThemeService {
    Theme addTheme(Theme theme);
    Theme getTheme(int themeId);
    List<Theme> getThemes();
    Theme updateTheme(int themeId,Theme theme);
    void deleteTheme(int themeId);
}
