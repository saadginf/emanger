package com.sab.authservice.service;

import java.util.List;

import com.sab.authservice.entities.AppRole;
import com.sab.authservice.entities.AppUser;

public interface AccountService {
    AppUser addNewUser(AppUser aU);

    AppRole addNewRole(AppRole aR);

    void addRoleToUser(String username, String roleName);

    AppUser loadUserByUsername(String username);

    List<AppUser> listUers();
}