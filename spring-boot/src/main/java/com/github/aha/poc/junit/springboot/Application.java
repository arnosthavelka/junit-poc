package com.github.aha.poc.junit.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) { // NOSONAR (due to safe usage of argument)
		SpringApplication.run(Application.class, args);
	}	

}