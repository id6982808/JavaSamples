package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class DemoApplication {
	
	public static void main(String[] args) {		
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages/Messages");
		messageSource.addBasenames("messages/Messages", "messages/validation-messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

}
