package com.gradleproject.demo_gradle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gradleproject.demo_gradle.dto.ZaikoDto;

@Repository
public interface ZaikoDtoRepository extends JpaRepository<ZaikoDto, Long> {
	
	/***
	 * 在庫情報 全件取得
	 * @return
	 */
	@Transactional(readOnly = true, timeout = 10)
	@Query(name = "query.zaiko_location.select_all", nativeQuery = true)
	public List<ZaikoDto> selectAllZaikoData();
}
