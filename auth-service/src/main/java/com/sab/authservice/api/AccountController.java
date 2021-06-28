package com.sab.authservice.api;

import java.util.List;

import com.sab.authservice.entities.AppRole;
import com.sab.authservice.entities.AppUser;
import com.sab.authservice.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AccountController {
    @Autowired
    AccountService acService;

    @GetMapping("/users")
    public List<AppUser> appUsers() {
        return acService.listUers();
    }

    @PostMapping("/users")
    public AppUser addAppUser(@RequestBody AppUser aUser) {
        return acService.addNewUser(aUser);
    }

    @PostMapping("/roles")
    public AppRole addAppRole(@RequestBody AppRole aRole) {
        return acService.addNewRole(aRole);
    }

    @PostMapping("/addRoles")
    public void addUserRole(@RequestBody RoleUserForm userRole) {

        acService.addRoleToUser(userRole.getUsername(), userRole.getRole());
    }

}

class RoleUserForm {
    private String username;
    private String role;

    /**
     * @return String return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return String return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

}