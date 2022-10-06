package com.gradleproject.demo_gradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoGradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGradleApplication.class, args);
		
		System.out.println("application start.");
	}

}
