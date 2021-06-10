package com.eventsvc.eventservice.services;

import java.util.List;

import com.eventsvc.eventservice.entities.Event;

public interface EventService {
    public Event addEvent(Event e);

    public List<Event> getAllEvents();

    public List<Event> getEventsByTh();
}