package com.gradleproject.demo_gradle.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gradleproject.demo_gradle.dto.RestResponseDtoForZipCode;

@RestController
public class CallExternalAPIController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("api/ex/zipcode")
	public void callZipcodeAPI() throws JsonMappingException, JsonProcessingException {
		String url = "https://zipcloud.ibsnet.co.jp/api/search?zipcode=7830060";
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		ResponseEntity<RestResponseDtoForZipCode> response2 = restTemplate.exchange(url, HttpMethod.GET, null, RestResponseDtoForZipCode.class);
		
		//var ret = restTemplate.getForObject(url, Object.class);
		//System.out.println(ret.toString());
		
		String strBody = response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		//TypeReference<Map<String, Object>> type = new TypeReference<Map<String, Object>>(){};
		Map<String, Object> body = mapper.readValue(strBody, Map.class);
		
		System.out.println(body);
	}
	
	
}
