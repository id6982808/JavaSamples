package com.gradleproject.demo_gradle.dto;

import java.util.List;

public class RestResponseDtoForZipCode {
	
	public String message;
	
	public List<Result> results;
	
	public String status;
	
	public static class Result {
		
		public String address1;
		
		public String address2;
		
		public String address3;
		
		public String kana1;
		
		public String kana2;
		
		public String kana3;
		
		public String prefcode;
		
		public String zipcode;
	}
	/*
	private Map<String, String> results;
	
	public void setResults(String key, String value) {
		results.put(key, value);
	}
	
	public String getResults(String key) {
		return results.get(key);
	}*/
}
