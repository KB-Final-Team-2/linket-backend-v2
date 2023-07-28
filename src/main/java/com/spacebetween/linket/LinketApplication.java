package com.spacebetween.linket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LinketApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinketApplication.class, args);
	}

}
