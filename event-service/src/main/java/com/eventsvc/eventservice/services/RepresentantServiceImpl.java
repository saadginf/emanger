package com.eventsvc.eventservice.services;

import java.util.List;

import com.eventsvc.eventservice.dao.RepresentantRepo;
import com.eventsvc.eventservice.entities.Representant;
import com.eventsvc.eventservice.exceptions.LibbeleException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepresentantServiceImpl implements RepresentantService {
    @Autowired
    RepresentantRepo rRepo;

    @Override
    public Representant addRepres(Representant r) {
        try {

            return rRepo.save(r);
        } catch (Exception ex) {
            throw new LibbeleException("Erreur Fatale");
        }
    }

    @Override
    public List<Representant> getAllRepresentants() {
        return rRepo.findAll();
    }

    @Override
    public Representant getById(Long id) {
        return rRepo.findById(id).get();
    }

}