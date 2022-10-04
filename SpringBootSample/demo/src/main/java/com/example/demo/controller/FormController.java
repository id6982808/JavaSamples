package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.bean.MyForm;

@Controller
@RequestMapping("/form")
public class FormController {
	
	@GetMapping
	public String init(Model model) {
		model.addAttribute(new MyForm());
		return "form";
	}
	
	@PostMapping
	public String submit(MyForm form) {
		System.out.println("form.value=" + form.getValue());
		return "form";
	}
}
