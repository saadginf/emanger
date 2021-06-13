package com.eventsvc.eventservice.services;

import java.util.List;

import com.eventsvc.eventservice.dao.EventRepo;
import com.eventsvc.eventservice.entities.Event;
import com.eventsvc.eventservice.entities.Theme;
import com.eventsvc.eventservice.exceptions.LibbeleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventRepo eRepo;

    @Override
    public Event addEvent(Event e) {
        try {

            return eRepo.save(e);
        } catch (Exception ex) {
            throw new LibbeleException("Erreur Fatale");
        }
    }

    @Override
    public List<Event> getAllEvents() {
        return eRepo.findAll();
    }

    @Override
    public List<Event> getEventsByTh(Theme th) {

        return eRepo.findByThemEvent(th);

    }

    @Override
    public Event getById(Long id) {
        return eRepo.findById(id).get();
    }

}