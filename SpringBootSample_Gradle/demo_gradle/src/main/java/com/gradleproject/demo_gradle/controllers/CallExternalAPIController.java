package com.gradleproject.demo_gradle.controllers;

import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gradleproject.demo_gradle.dto.RestResponseDtoForZipCode;
import com.gradleproject.demo_gradle.service.RestClient;

@RestController
public class CallExternalAPIController {
	
	@Autowired
	RestClient client;
	
	/***
	 * JSONで取得する
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@GetMapping("api/ex/zipcode/json/{p_zipcode}")
	public ResponseEntity<RestResponseDtoForZipCode> callZipcodeJsonAPI(@PathVariable("p_zipcode") String p_zipcode) throws JsonMappingException, JsonProcessingException {
		String url = "https://zipcloud.ibsnet.co.jp/api/search?zipcode={p_zipcode}";
		
		ResponseEntity<RestResponseDtoForZipCode> responseEntity = client.getRestTemplateJson().exchange(url, HttpMethod.GET, null, RestResponseDtoForZipCode.class, p_zipcode);

		return responseEntity;
	}
	
	/***
	 * 文字列で取得する
	 * @param p_zipcode
	 * @return
	 */
	@GetMapping("api/ex/zipcode/str/{p_zipcode}")
	public ResponseEntity<String> callZipcodeStrAPI(@PathVariable("p_zipcode") String p_zipcode) {
		String url = "https://zipcloud.ibsnet.co.jp/api/search?zipcode={p_zipcode}";
		
		ResponseEntity<String> responseEntity = client.getRestTemplate().exchange(url, HttpMethod.GET, null, String.class, p_zipcode);
		
		return responseEntity;
	}
	
	/***
	 * 文字列型で取得したResponseEntityの手動変換サンプル
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@GetMapping("api/ex/zipcode/str2json")
	public void callSample() throws JsonMappingException, JsonProcessingException {
		String url = "https://zipcloud.ibsnet.co.jp/api/search?zipcode=9695123";
		
		ResponseEntity<String> response = client.getRestTemplate().exchange(url, HttpMethod.GET, null, String.class);
		
		convertStr2Json(response);
	}
	
	/***
	 * 文字列で取得したJSON情報をMap型に変換する
	 * @param response
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	private Map<String, Object> convertStr2Json(ResponseEntity<String> response) throws JsonMappingException, JsonProcessingException {
		
		String strBody = response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		//TypeReference<Map<String, Object>> type = new TypeReference<Map<String, Object>>(){};
		Map<String, Object> body = mapper.readValue(strBody, Map.class);
		
		Iterator<String> key_itr = body.keySet().iterator();
		while (key_itr.hasNext()) {
			String key = key_itr.next();
			
			System.out.println("key, value = " + key + ", " + body.get(key));
		}
		
		return body;
	}
}
