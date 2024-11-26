package com.microcervice.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.netflix.hystrix.util.Exceptions;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SpringbootServiceOauthApplication {

	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceOauthApplication.class, args);
	}
	
	public void run(String...args)throws Exceptions{
		String pss=("12345");
		
		for (int=i=0; 1<2; i++) {
			String passCry = passEncoder,encode(pss);
			System.out.println(passCry);
		}
	}

}
