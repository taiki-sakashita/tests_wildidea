package com.api.hellow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.api" })
public class HellowApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellowApplication.class, args);
	}

}
