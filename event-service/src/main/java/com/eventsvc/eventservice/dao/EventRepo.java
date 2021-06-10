package com.eventsvc.eventservice.dao;

import java.util.List;

import com.eventsvc.eventservice.entities.Event;
import com.eventsvc.eventservice.entities.Theme;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends JpaRepository<Event, Long> {
    List<Event> findByThemEvent(Theme themEvent);
}