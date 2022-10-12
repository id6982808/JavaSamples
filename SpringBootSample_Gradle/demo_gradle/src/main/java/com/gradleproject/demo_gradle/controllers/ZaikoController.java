package com.gradleproject.demo_gradle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gradleproject.demo_gradle.entities.Zaiko;
import com.gradleproject.demo_gradle.service.ZaikoService;

@Controller
@RequestMapping("/zaiko")
public class ZaikoController {
	
	@Autowired
	ZaikoService zaikoService;
	
	@GetMapping
	public String index(Model model) {
		return "zaiko/index";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		List<Zaiko> zaikos = zaikoService.findAll();
		model.addAttribute("zaikos", zaikos);
		return "zaiko/list";
	}
	
	@GetMapping("api/test/insert")
	public void apiTestInsert() {
		
	}
}
