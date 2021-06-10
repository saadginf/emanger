package com.eventsvc.eventservice.dao;

import com.eventsvc.eventservice.entities.Theme;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepo extends JpaRepository<Theme, Long> {

}