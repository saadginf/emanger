package com.eventsvc.eventservice.services;

import java.util.List;

import com.eventsvc.eventservice.entities.Event;
import com.eventsvc.eventservice.entities.Theme;
import com.eventsvc.eventservice.outils.EventResume;

public interface EventService {
    public Event addEvent(Event e);

    public Event getById(Long id);

    public List<EventResume> getAllEvents();

    public List<Event> getEventsByTh(Theme th);

    public void deleteEvent(Long id);

    public List<Event> getEvents(Long[] ids);
}