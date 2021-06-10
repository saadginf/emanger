package com.eventsvc.eventservice.services;

import java.util.List;

import com.eventsvc.eventservice.entities.Theme;

public interface ThemeService {
    public Theme addTheme(Theme t);

    public Theme findById(Long id);

    public List<Theme> getAllThemes();
}