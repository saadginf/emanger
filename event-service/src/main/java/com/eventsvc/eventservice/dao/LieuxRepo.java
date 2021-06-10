package com.eventsvc.eventservice.dao;

import com.eventsvc.eventservice.entities.Lieux;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LieuxRepo extends JpaRepository<Lieux, Long> {

}