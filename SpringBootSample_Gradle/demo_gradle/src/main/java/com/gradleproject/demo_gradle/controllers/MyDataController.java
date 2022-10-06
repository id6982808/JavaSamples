package com.gradleproject.demo_gradle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gradleproject.demo_gradle.entities.MyData;
import com.gradleproject.demo_gradle.repository.MyDataRepository;

@Controller
public class MyDataController {
	
	@Autowired
	MyDataRepository repository;
	
	@RequestMapping("/mydata")
	public String mydata(Model model) {
		Iterable<MyData> list = repository.findAll();
		model.addAttribute("mydata", list);
		return "mydata_view";
	}
}
