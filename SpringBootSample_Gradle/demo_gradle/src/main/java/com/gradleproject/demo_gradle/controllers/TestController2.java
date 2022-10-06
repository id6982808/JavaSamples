package com.gradleproject.demo_gradle.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController2 {
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("message", "Hello Thymeleaf!!");
		return "hello";
	}
}
