package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.resrc.MyException;

@RestController
@RequestMapping("/api")
public class WebApiController {
	
	@RequestMapping(method=RequestMethod.GET)
	public void method1() {
		throw new MyException("test exception");
	}
	
	@RequestMapping(value="/null", method=RequestMethod.GET)
	public void method2() {
		throw new NullPointerException("test exception");
	}
}
