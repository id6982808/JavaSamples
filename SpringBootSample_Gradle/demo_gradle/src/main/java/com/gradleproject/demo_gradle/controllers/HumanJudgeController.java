package com.gradleproject.demo_gradle.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gradleproject.demo_gradle.dto.CreatureDto;
import com.gradleproject.demo_gradle.service.RestClient;

@RestController
public class HumanJudgeController {
	
	private final RestClient client;
	
	public HumanJudgeController(RestClient client) {
		this.client = client;
	}
	
	@PostMapping("/judge")
	public List<CreatureDto> judgeHuman(@RequestBody List<CreatureDto> creature) {
		List<CreatureDto> resultList = new ArrayList<CreatureDto>();
		
		for (int i = 0; i < creature.size(); i++) {
			if (creature.get(i).getType().equals("human")) {
				resultList.add(creature.get(i));
			}
		}
		
		return resultList;
	}
	
	/***
	 * テストのためにPOST通信を呼び出す。REST Clientを使用する。
	 * @return
	 */
	@GetMapping("/test/creature")
	public ResponseEntity<List<CreatureDto>> test() {
		String url = "http://localhost:8080/judge";
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		List<CreatureDto> creatureDtoList = new ArrayList<CreatureDto>();
		creatureDtoList.add(new CreatureDto("name1", "animal"));
		creatureDtoList.add(new CreatureDto("name2", "human"));
		creatureDtoList.add(new CreatureDto("name3", "animal"));
		
		// リストのクラス型
		Class<List<CreatureDto>> clazz = (Class) List.class;
		
		HttpEntity<List<CreatureDto>> entity = new HttpEntity<>(creatureDtoList, headers);
		ResponseEntity<List<CreatureDto>> responseEntity = client.getRestTemplate().exchange(url, HttpMethod.POST, entity, clazz);
		
		return responseEntity;
	}
}
