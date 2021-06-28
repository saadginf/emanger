package com.sab.authservice;

import java.util.ArrayList;
import java.util.Collection;

import com.sab.authservice.entities.AppRole;
import com.sab.authservice.entities.AppUser;
import com.sab.authservice.service.AccountService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(AccountService aService) {
		return args -> {
			System.out.println("___________CREATION USER __________");
			AppUser user = aService.loadUserByUsername("admin");

			if (user == null) {
				AppRole roleU = new AppRole();
				roleU.setRoleName("user");
				AppRole roleUser = aService.addNewRole(roleU);
				AppRole roleA = new AppRole();
				roleA.setRoleName("admin");
				AppRole roleAdmin = aService.addNewRole(roleA);
				Collection<AppRole> appRoles = new ArrayList<>();
				appRoles.add(roleAdmin);
				appRoles.add(roleUser);
				AppUser user1 = new AppUser();
				user1.setAppRoles(appRoles);
				user1.setUsername("admin");
				user1.setPassword("admin");
				aService.addNewUser(user1);
			}
		};

	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
