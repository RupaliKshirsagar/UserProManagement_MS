package com.jbk.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class UserProManagementMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProManagementMsApplication.class, args);
	}
	@Bean 
	public RestTemplate restTemplate() {
		return new RestTemplate();
		
	}

}
//http://localhost:9191/user/getUser/Rupali