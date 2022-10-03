package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.resrc.Hoge;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping(value="/h1", method=RequestMethod.GET)
	public String hello(Model model) {
		return "hello";
	}
	
	@RequestMapping(value="/h2", method=RequestMethod.GET)
	public String hello2(Model model) {
		Hoge hoge = new Hoge();
		hoge.id = 10;
		hoge.value = "hoge";
		
		model.addAttribute("myData", hoge);
		
		return "hello2";
	}
	
	@RequestMapping(value="/h3", method=RequestMethod.GET)
	public String hello3(Model model) {
		List<Hoge> list = Arrays.asList(
				new Hoge() {{
					id = 10;
					value = "hoge";
				}},
				new Hoge() {{
					id = 20;
					value = "fuga";
				}},
				new Hoge() {{
					id = 30;
					value = "piyo";
				}}
				);
		model.addAttribute("hogeList", list);
		return "hello3";
	}
}
