package com.example.resrc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/*
 * https://qiita.com/salvage0707/items/0ed226c97f86bf008522
 */

public class RestTemplateSampleServiceImpl implements RestTemplateSampleService {
	
	@Autowired
	RestTemplate restTemplate;
	
	public static final String URL = "http://localhost:8080/rest001";
	
	public TestResponseResource getTestResponse() {
		return restTemplate.getForObject(URL, TestResponseResource.class);
	}
}
