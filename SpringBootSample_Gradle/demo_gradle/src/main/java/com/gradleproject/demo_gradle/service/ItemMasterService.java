package com.gradleproject.demo_gradle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gradleproject.demo_gradle.entities.ItemMaster;
import com.gradleproject.demo_gradle.repository.ItemMasterRepository;

@Service
public class ItemMasterService {
	
	/***
	 * 商品マスタレポジトリ
	 */
	@Autowired
	ItemMasterRepository itemMasterRepository;
	
	/***
	 * 全検索
	 */
	public List<ItemMaster> selectAll() {
		var list = itemMasterRepository.findAll();
		
		return list;
	}
}
