package com.gradleproject.demo_gradle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gradleproject.demo_gradle.entities.Zaiko;
import com.gradleproject.demo_gradle.service.ZaikoService;

@Controller
@RequestMapping("/zaiko")
public class ZaikoController {
	
	/***
	 * 在庫データレポジトリ　アクセス用サービス
	 */
	@Autowired
	ZaikoService zaikoService;
	
	/***
	 * インデックスページ(TOP)
	 * @param model
	 * @return
	 */
	@GetMapping
	public String index(Model model) {
		return "zaiko/index";
	}
	
	/***
	 * 一覧表示
	 * @param model
	 * @return
	 */
	@GetMapping("list")
	public String list(Model model) {
		List<Zaiko> zaikos = zaikoService.findAll();
		model.addAttribute("zaikos", zaikos);
		return "zaiko/list";
	}
	
	/***
	 * 詳細表示
	 */
	@GetMapping("{id}/detail")
	public String detail(@PathVariable Long id, Model model) {
		Zaiko zaiko = zaikoService.findOne(id);
		
		model.addAttribute("zaiko", zaiko);
		return "zaiko/detail";
	}
	
	/***
	 * 修正
	 */
	@GetMapping("{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		Zaiko zaiko = zaikoService.findOne(id);
		
		model.addAttribute("zaiko", zaiko);
		return "zaiko/edit";
	}
	
	/***
	 * APIテスト実行画面
	 */
	@GetMapping("api")
	public String api(Model model) {
		return "zaiko/api";
	}
	
	/***
	 * テストデータ投入API
	 * @return String
	 */
	@GetMapping("api/test/insert")
	public String apiTestInsert() {
		zaikoService.insertByTestData();
		return "zaiko/index";
	}
	
	/***
	 * 全データ削除API
	 */
	@GetMapping("api/deleteall")
	public String apiDeleteAll() {
		zaikoService.deleteAll();
		return "zaiko/index";
	}
}
