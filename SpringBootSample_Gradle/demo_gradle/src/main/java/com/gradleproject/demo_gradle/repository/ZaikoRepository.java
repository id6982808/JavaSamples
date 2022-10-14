package com.gradleproject.demo_gradle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gradleproject.demo_gradle.entities.Zaiko;

@Repository
public interface ZaikoRepository extends JpaRepository<Zaiko, Long> {
	
	/***
	 * ネイティブクエリテスト
	 * @return
	 */
	@Query(name = "query.002.zaiko_location.select", nativeQuery = true)
	public List<Zaiko> selectAllByIdDesc();
	
	/***
	 * ネイティブクエリテスト
	 * @return
	 */
	@Transactional(readOnly = true, timeout = 10)
	@Query(name = "query.003.zaiko_location.select", nativeQuery = true)
	public List<Zaiko> selectAsterFromSomeTable();
	
}
