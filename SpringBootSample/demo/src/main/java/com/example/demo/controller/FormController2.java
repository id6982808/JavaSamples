package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.bean.MyFormCheckBox;

@Controller
@RequestMapping("/form2")
public class FormController2 {
	
	@GetMapping
	public String init(Model model) {
		model.addAttribute(new MyFormCheckBox());
		return "form2";
	}
	
	@PostMapping
	public String submit(MyFormCheckBox form) {
		System.out.println("form.value=" + form.isChecked());
		return "form2";
	}
}
