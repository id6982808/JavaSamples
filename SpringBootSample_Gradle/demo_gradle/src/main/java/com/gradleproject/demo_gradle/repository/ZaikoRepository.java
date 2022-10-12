package com.gradleproject.demo_gradle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gradleproject.demo_gradle.entities.Zaiko;

@Repository
public interface ZaikoRepository extends JpaRepository<Zaiko, Long> {
	
}
