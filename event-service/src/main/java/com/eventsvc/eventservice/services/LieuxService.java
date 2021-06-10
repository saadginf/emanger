package com.eventsvc.eventservice.services;

import java.util.List;

import com.eventsvc.eventservice.entities.Lieux;

public interface LieuxService {
    public Lieux addLieux(Lieux l);

    public Lieux getById(Long id);

    public List<Lieux> getAllLieux();

}