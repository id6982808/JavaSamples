package com.gradleproject.demo_gradle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradleproject.demo_gradle.dto.ItemMasterPK;
import com.gradleproject.demo_gradle.entities.ItemMaster;

public interface ItemMasterRepository extends JpaRepository<ItemMaster, ItemMasterPK> {
	
}
