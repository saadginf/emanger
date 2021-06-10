package com.eventsvc.eventservice.dao;

import com.eventsvc.eventservice.entities.Representant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepresentantRepo extends JpaRepository<Representant, Long> {

}