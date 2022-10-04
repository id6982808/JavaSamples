package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/h4")
	public String hello4(Model model) {
		model.addAttribute("hoge", new Hoge2());
		return "hello4";
	}
	
	public static class Hoge2 {
		public int publicField = 1;
		public int publicMethod() { return 2; }
		public int getPublicValue() { return 3; }
	}
	
	@GetMapping("/h5")
	public String hello5(Model model) {
		HashMap<String, String> map = new HashMap();
		map.put("message", "Hello World!!");
		model.addAttribute("map", map);
		return "hello5";
	}
	
	@GetMapping("/h6")
	public String hello6(Model model) {
		return "hello6";
	}
	
	@GetMapping("/h7")
	public String hello7(Model model) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i=0; i<50; i++) {
			list.add(i);
		}
		model.addAttribute("list", list);
		return "hello7";
	}
	
	@GetMapping("/h8")
	public String hello8(Model model) {
		return "hello8";
	}
	
	@GetMapping("/h9")
	public String hello9(Model model) {
		return "hello9";
	}
	
	@GetMapping("/h10")
	public String hello10(Model model) {
		return "hello10";
	}
	
	@GetMapping("/h11")
	public String hello11(Model model) {
		return "hello11";
	}
	
	@GetMapping("/h12")
	public String hello12(Model model) {
		return "hello12";
	}
}
