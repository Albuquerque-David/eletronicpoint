package com.eletronicpoint.pontointeligente.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.eletronicpoint.pontointeligente.api.repositories")
public class EletronicPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(EletronicPointApplication.class, args);
	}

}
