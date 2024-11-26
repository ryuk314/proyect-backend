package com.microcervice.celulares;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootServiceCelularesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceCelularesApplication.class, args);
	}

}
