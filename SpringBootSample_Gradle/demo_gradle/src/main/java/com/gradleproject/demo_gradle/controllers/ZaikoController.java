package com.gradleproject.demo_gradle.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gradleproject.demo_gradle.dto.ZaikoDto;
import com.gradleproject.demo_gradle.entities.ItemMaster;
import com.gradleproject.demo_gradle.service.ItemMasterService;
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
	 * 商品マスタレポジトリ アクセス用サービス
	 */
	@Autowired
	ItemMasterService itemMasterService;
	
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
	 * 新規
	 */
	@GetMapping("new")
	public String newZaiko(Model model) {
		ZaikoDto zaikoDto = new ZaikoDto();
		
		model.addAttribute("zaikoDto", zaikoDto);
		return "zaiko/new";
	}
	
	/***
	 * 新規登録
	 */
	@PostMapping("regist")
	public String regist(@Valid @ModelAttribute ZaikoDto zaikoDto, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) return "zaiko/new";
		
		zaikoService.save(zaikoDto);
		return list(model);
	}
	
	/***
	 * 一覧表示
	 * @param model
	 * @return
	 */
	@GetMapping("list")
	public String list(Model model) {
		List<ZaikoDto> zaikoDtoList = zaikoService.findAll();
		model.addAttribute("zaikoDtoList", zaikoDtoList);
		return "zaiko/list";
	}
	
	/***
	 * 詳細表示
	 */
	@GetMapping("{id}/detail")
	public String detail(@PathVariable Long id, Model model) {
		ZaikoDto zaikoDto = zaikoService.findOne(id);
		
		model.addAttribute("zaikoDto", zaikoDto);
		return "zaiko/detail";
	}
	
	/***
	 * 修正
	 */
	@GetMapping("{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		ZaikoDto zaikoDto = zaikoService.findOne(id);
		
		model.addAttribute("zaikoDto", zaikoDto);
		return "zaiko/edit";
	}
	
	/***
	 * 修正実行
	 */
	@PutMapping("{id}/modify")
	public String modify(@PathVariable Long id, @ModelAttribute ZaikoDto zaikoDto) {
		zaikoDto.setZaikoId(id);
		zaikoService.save(zaikoDto);
		
		return "zaiko/detail";
	}
	
	/***
	 * 削除実行
	 */
	@DeleteMapping("{id}/delete")
	public String delete(@PathVariable Long id, Model model) {
		zaikoService.delete(id);
		
		return list(model);
	}
	
	/***
	 * 商品マスタ 一覧表示
	 */
	@GetMapping("item_master")
	public String item_master(Model model) {
		List<ItemMaster> itemMasterList = itemMasterService.selectAll();
		
		model.addAttribute("itemMasterList", itemMasterList);
		
		return "zaiko/item_master";
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
	
	/***
	 * nativeクエリテストAPI
	 */
	@GetMapping("api/test/query")
	public String apiTestQuery() {
		zaikoService.executeNativeQuery();
		return "zaiko/index";
	}
}
