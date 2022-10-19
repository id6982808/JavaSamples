package com.gradleproject.demo_gradle.dto;

import java.util.List;

import lombok.Data;

@Data
public class RestResponseDtoForZipCode {
	
	private String message;
	
	private List<Result> results;
	
	private String status;
	
	@Data
	public static class Result {
		
		private String address1;
		
		private String address2;
		
		private String address3;
		
		private String kana1;
		
		private String kana2;
		
		private String kana3;
		
		private String prefcode;
		
		private String zipcode;
	}
}
