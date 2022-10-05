package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.bean.MyForm4;

@Controller
@RequestMapping("/form4")
public class FormController4 {
	
	@GetMapping
	public String init(Model model) {
		model.addAttribute(new MyForm4());
		return "form4";
	}
	
	@PostMapping
	public String submit(@Validated MyForm4 form, BindingResult result) {
		System.out.println("****");
		System.out.println("form = " + form);
		System.out.println("result = " + result);
		System.out.println("****");
		return "form4";
	}
}
