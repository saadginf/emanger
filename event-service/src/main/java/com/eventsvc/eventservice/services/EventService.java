package com.eventsvc.eventservice.services;

import java.util.List;

import com.eventsvc.eventservice.entities.Event;
import com.eventsvc.eventservice.entities.Theme;

public interface EventService {
    public Event addEvent(Event e);

    public Event getById(Long id);

    public List<Event> getAllEvents();

    public List<Event> getEventsByTh(Theme th);
}