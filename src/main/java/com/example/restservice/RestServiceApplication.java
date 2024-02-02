package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.example.restservice.equipmentData",
		"com.example.restservice.storageData",
		"com.example.restservice.workshopData"
})
//@EnableJpaRepositories
public class RestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(
				RestServiceApplication.class, args);
	}

}
