package com.pass.jav;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pass.jav.domain.AppUsers;
import com.pass.jav.service.UsersService;

@SpringBootApplication
public class JavApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(UsersService usersService) {
		return args -> {

			usersService.guardar(new AppUsers("admin", "renaido"));
		

		};
	}

}
