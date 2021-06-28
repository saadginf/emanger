package com.eventsvc.eventservice.services;

import java.util.List;

import com.eventsvc.eventservice.dao.LieuxRepo;
import com.eventsvc.eventservice.dao.RepresentantRepo;
import com.eventsvc.eventservice.dao.ThemeRepo;
import com.eventsvc.eventservice.entities.Lieux;
import com.eventsvc.eventservice.entities.Representant;
import com.eventsvc.eventservice.entities.Theme;
import com.eventsvc.eventservice.outils.Fields;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldsServiceImpl implements FieldsService {
    @Autowired
    RepresentantRepo rRepo;
    @Autowired
    ThemeRepo thRepo;
    @Autowired
    LieuxRepo lRepo;

    @Override
    public Fields getAll() {
        Fields f = new Fields();
        List<Lieux> lieux = lRepo.findAll();
        List<Representant> representants = rRepo.findAll();
        List<Theme> themes = thRepo.findAll();
        f.setLieux(lieux);
        f.setRepresentants(representants);
        f.setThemes(themes);
        return f;
    }

}