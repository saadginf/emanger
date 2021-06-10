package com.eventsvc.eventservice.dao;

import com.eventsvc.eventservice.entities.Theme;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepo extends JpaRepository<Theme, Long> {

}