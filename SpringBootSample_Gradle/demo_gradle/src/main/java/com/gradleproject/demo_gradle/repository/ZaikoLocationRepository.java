package com.gradleproject.demo_gradle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gradleproject.demo_gradle.entities.ZaikoLocation;

@Repository
public interface ZaikoLocationRepository extends JpaRepository<ZaikoLocation, Long> {
	
	/***
	 * 在庫保管場所 外部キーによる1件削除
	 */
	@Modifying
	@Transactional
	@Query(name = "query.location.delete_fk", nativeQuery = true)
	public void deleteByForeignKey(@Param("id") Long id);
}
