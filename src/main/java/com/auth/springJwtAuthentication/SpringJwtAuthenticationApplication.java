package com.auth.springJwtAuthentication;

import com.auth.springJwtAuthentication.auth.AuthenticationService;
import com.auth.springJwtAuthentication.auth.RegisterRequest;
import com.auth.springJwtAuthentication.user.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.auth.springJwtAuthentication.user.Role.ADMIN;
import static com.auth.springJwtAuthentication.user.Role.MANAGER;

@SpringBootApplication
public class SpringJwtAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtAuthenticationApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("admin@mail.com")
					.password("password")
					.role(ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());

			var manager = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("manager@mail.com")
					.password("password")
					.role(MANAGER)
					.build();
			System.out.println("Manager token: " + service.register(manager).getAccessToken());

		};
	}
}
