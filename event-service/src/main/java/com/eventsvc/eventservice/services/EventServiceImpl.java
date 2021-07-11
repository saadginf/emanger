package com.eventsvc.eventservice.services;

import java.util.ArrayList;
import java.util.List;

import com.eventsvc.eventservice.dao.EventRepo;
import com.eventsvc.eventservice.entities.Event;
import com.eventsvc.eventservice.entities.Theme;
import com.eventsvc.eventservice.exceptions.LibbeleException;
import com.eventsvc.eventservice.outils.EventResume;

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
    public List<EventResume> getAllEvents() {
        List<Event> events = eRepo.findAll();
        List<EventResume> resume = new ArrayList<>();
        for (Event event : events) {
            EventResume eR = new EventResume();
            eR.setBgColor(event.getBgColor());
            eR.setEnd(event.getEndDate());
            eR.setStart(event.getStartDate());
            eR.setId(event.getId());
            eR.setTitle(event.getObjet());
            resume.add(eR);
        }

        return resume;
    }

    @Override
    public List<Event> getEventsByTh(Theme th) {

        return eRepo.findByThemEvent(th);

    }

    @Override
    public Event getById(Long id) {
        return eRepo.findById(id).get();
    }

    @Override
    public void deleteEvent(Long id) {

        eRepo.deleteById(id);

    }

    @Override
    public List<Event> getEvents(Long[] ids) {
        // TODO Auto-generated method stub
        List<Event> events = new ArrayList<>();
        for (Long id : ids) {
            Event e = eRepo.findById(id).get();
            events.add(e);
        }
        return events;
    }

    @Override
    public Event editEvent(Event e) {
        Event event = eRepo.getOne(e.getId());
        event.setActivites(e.getActivites());
        event.setSuggestions(e.getSuggestions());
        event.setRepresentants(e.getRepresentants());
        event.setFileLink(e.getFileLink());
        return eRepo.save(event);
    }

}