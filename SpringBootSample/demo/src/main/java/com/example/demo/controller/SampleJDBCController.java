package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Person;
import com.example.demo.service.SampleJDBCService;

@RestController
public class SampleJDBCController {
	
	@Autowired
	private SampleJDBCService service;
	
	@RequestMapping("/add/{name}")
	public List<Person> index(@ModelAttribute Person person) {
		service.save(person);
		return service.findAll();
	}
}
