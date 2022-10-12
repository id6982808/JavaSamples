package com.gradleproject.demo_gradle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gradleproject.demo_gradle.entities.Zaiko;
import com.gradleproject.demo_gradle.repository.ZaikoRepository;

@Service
public class ZaikoService {
	
	@Autowired
	private ZaikoRepository zaikoRepository;
	
	public List<Zaiko> findAll() {
		return zaikoRepository.findAll();
	}
	
	public Zaiko findOne(Long id) {
		return zaikoRepository.findById(id).orElse(null);
	}
	
	public Zaiko save(Zaiko zaiko) {
		return zaikoRepository.save(zaiko);
	}
	
	public void insertByTestData() {
		
		int num_of_record = 100;
		
		for (int i = 0; i < num_of_record; i++) {
			Zaiko tmp = new Zaiko();
			
			tmp.setProductName("test-data-" + i);
		}
		
		
	}
}
