package com.sab.authservice.dao;

import com.sab.authservice.entities.AppRole;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepo extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);
}