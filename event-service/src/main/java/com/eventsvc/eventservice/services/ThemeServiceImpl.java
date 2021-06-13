package com.eventsvc.eventservice.services;

import java.util.List;

import com.eventsvc.eventservice.dao.ThemeRepo;
import com.eventsvc.eventservice.entities.Theme;
import com.eventsvc.eventservice.exceptions.LibbeleException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThemeServiceImpl implements ThemeService {
    @Autowired
    ThemeRepo thRepo;

    @Override
    public Theme addTheme(Theme t) {
        try {

            return thRepo.save(t);
        } catch (Exception ex) {
            throw new LibbeleException("Erreur Fatale");
        }
    }

    @Override
    public List<Theme> getAllThemes() {
        return thRepo.findAll();
    }

    @Override
    public Theme findById(Long id) {
        return thRepo.findById(id).get();
    }

}