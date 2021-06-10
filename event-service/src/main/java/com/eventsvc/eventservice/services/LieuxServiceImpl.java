package com.eventsvc.eventservice.services;

import java.util.List;

import com.eventsvc.eventservice.dao.LieuxRepo;
import com.eventsvc.eventservice.entities.Lieux;
import com.eventsvc.eventservice.exceptions.LibbeleException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LieuxServiceImpl implements LieuxService {
    @Autowired
    LieuxRepo lRepo;

    @Override
    public Lieux addLieux(Lieux l) {
        try {
            return lRepo.save(l);
        } catch (Exception ex) {
            throw new LibbeleException("Erreur Fatale");
        }
    }

    @Override
    public Lieux getById(Long id) {
        return lRepo.getOne(id);
    }

    @Override
    public List<Lieux> getAllLieux() {
        return lRepo.findAll();
    }

}