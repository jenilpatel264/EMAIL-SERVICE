package com.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringEmailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailServiceApplication.class, args);
	}

}
