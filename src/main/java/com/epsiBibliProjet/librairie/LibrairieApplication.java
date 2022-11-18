package com.epsiBibliProjet.librairie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class LibrairieApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrairieApplication.class, args);
	}

}
