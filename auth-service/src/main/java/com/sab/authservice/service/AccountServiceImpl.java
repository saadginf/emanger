package com.sab.authservice.service;

import java.util.List;

import com.sab.authservice.dao.AppRoleRepo;
import com.sab.authservice.dao.AppUserRepo;
import com.sab.authservice.entities.AppRole;
import com.sab.authservice.entities.AppUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    AppUserRepo appUserRepo;
    @Autowired
    AppRoleRepo appRoleRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public AppUser addNewUser(AppUser aU) {
        // TODO Auto-generated method stub

        String pw = aU.getPassword();
        aU.setPassword(passwordEncoder.encode(pw));
        return appUserRepo.save(aU);
    }

    @Override
    public AppRole addNewRole(AppRole aR) {
        // TODO Auto-generated method stub
        return appRoleRepo.save(aR);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        // TODO Auto-generated method stub
        AppUser appUser = appUserRepo.findByUsername(username);
        AppRole appRole = appRoleRepo.findByRoleName(roleName);
        appUser.getAppRoles().add(appRole);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        // TODO Auto-generated method stub
        return appUserRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> listUers() {
        // TODO Auto-generated method stub
        return appUserRepo.findAll();
    }

}