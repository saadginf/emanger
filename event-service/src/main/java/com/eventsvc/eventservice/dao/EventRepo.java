package com.eventsvc.eventservice.dao;

import com.eventsvc.eventservice.entities.Event;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event, Long> {

}