package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.example.restservice.equipmentData",
		"com.example.restservice.storageData"
})
//@EnableJpaRepositories
public class RestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(
				RestServiceApplication.class, args);
	}

}
