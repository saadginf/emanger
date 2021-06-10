package com.eventsvc.eventservice.dao;

import com.eventsvc.eventservice.entities.Representant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepresentantRepo extends JpaRepository<Representant, Long> {

}