package com.teclead.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProgrammingTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgrammingTaskApplication.class, args);
		/*
		SpringApplication app = new SpringApplication(ProgrammingTaskApplication.class);
		app.setAdditionalProfiles("dev");
		app.run(args);
		*/
	}

}
