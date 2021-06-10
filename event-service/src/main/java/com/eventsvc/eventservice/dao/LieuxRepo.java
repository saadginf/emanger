package com.eventsvc.eventservice.dao;

import com.eventsvc.eventservice.entities.Lieux;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LieuxRepo extends JpaRepository<Lieux, Long> {

}