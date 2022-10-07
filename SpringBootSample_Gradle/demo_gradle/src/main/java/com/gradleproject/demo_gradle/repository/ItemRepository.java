package com.gradleproject.demo_gradle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradleproject.demo_gradle.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
