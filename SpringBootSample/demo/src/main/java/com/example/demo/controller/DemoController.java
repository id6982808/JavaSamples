package com.example.demo.controller;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.resrc.Greeting;
import com.example.resrc.MyException;

@RestController
public class DemoController {
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public void test() {
		System.out.println("GET : test");
	}
	
	@RequestMapping(value="web001", method=RequestMethod.GET, produces="text/plain;charset=SJIS")
	@ResponseBody
	public void viewDirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType(MediaType.TEXT_HTML_VALUE);
		response.getWriter().write("<html><body><h1>SpringBootコントローラによる簡易アプリ</h1></html>");
	}
	
	@GetMapping("/bar")
	public ResponseEntity bar() {
	    Map body = Map.of("message", "こんにちわ、世界。");
	    // Content-Type: application/json;charset=UTF-8 を指定
	    HttpHeaders headers = new HttpHeaders();
	    //headers.setContentType(new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8));
	    //headers.setContentType(new MediaType(MediaType.TEXT_HTML, StandardCharsets.UTF_8));
	    return new ResponseEntity<Map>(body, headers, HttpStatus.OK);
	}
	
	/* REST API の作成
	 * https://spring.pleiades.io/guides/gs/rest-service/
	 */
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@RequestMapping(value="/pathparam/{id}/{name}", method=RequestMethod.GET)
	public void getMethod(@PathVariable int id, @PathVariable String name) {
		System.out.println("id="+id+", name="+name);
	}
	
	@RequestMapping(value="/status400", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public void getStatus400() {
		
	}
	
	@RequestMapping(value="/exception", method=RequestMethod.GET)
	public void method1() {
		throw new MyException("test exception");
	}
}
