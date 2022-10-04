package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.bean.MyForm3;

@Controller
@RequestMapping("/form3")
public class FormController3 {
	
	@GetMapping
	public String init(Model model) {
		model.addAttribute(new MyForm3());
		return "form3";
	}
	
	@PostMapping(params="appendRow")
	public String appendRow(MyForm3 form) {
		form.appendRow();
		this.printRows(form);
		return "form3";
	}
	
	@PostMapping(params="removeIndex")
	public String submit(MyForm3 form, @RequestParam int removeIndex) {
		form.removeRow(removeIndex);
		this.printRows(form);
		return "form3";
	}
	
	private void printRows(MyForm3 form) {
		List<MyForm3.Row> rows = form.getRows();
		for(int i = 0; i < rows.size(); i++) {
			MyForm3.Row row = rows.get(i);
			System.out.println("i=" + i + ", row.value=" + row.getValue());
		}
	}
}
