package com.sab.authservice;

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

			AppUser user = aService.loadUserByUsername("admin");

			if (user == null) {
				System.out.println("___________CREATION ADMIN USER __________");
				aService.addNewAdmin();
			}
		};

	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
