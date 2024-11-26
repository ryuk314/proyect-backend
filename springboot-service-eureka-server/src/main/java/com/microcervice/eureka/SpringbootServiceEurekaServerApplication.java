package com.microcervice.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@SpringBootApplication
@EnableZuulServer
public class SpringbootServiceEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceEurekaServerApplication.class, args);
	}

}
