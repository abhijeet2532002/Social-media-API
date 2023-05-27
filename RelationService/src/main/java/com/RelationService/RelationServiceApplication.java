package com.RelationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RelationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelationServiceApplication.class, args);
		System.out.println("\nRelation service is running .... \n");
	}

}
