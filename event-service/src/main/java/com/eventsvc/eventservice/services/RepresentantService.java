package com.eventsvc.eventservice.services;

import java.util.List;

import com.eventsvc.eventservice.entities.Representant;

public interface RepresentantService {
    public Representant addRepres(Representant r);

    public Representant getById(Long id);

    public List<Representant> getAllRepresentants();

}