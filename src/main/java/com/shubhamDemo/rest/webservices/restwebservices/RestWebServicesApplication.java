package com.shubhamDemo.rest.webservices.restwebservices;

import org.apache.commons.lang3.concurrent.Computable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class RestWebServicesApplication {


	public static void main(String[] args) {
		SpringApplication.run(RestWebServicesApplication.class, args);
	}

}
