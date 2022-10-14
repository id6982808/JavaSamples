package com.gradleproject.demo_gradle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gradleproject.demo_gradle.dto.ZaikoDto;
import com.gradleproject.demo_gradle.entities.Zaiko;
import com.gradleproject.demo_gradle.entities.ZaikoLocation;
import com.gradleproject.demo_gradle.repository.ZaikoDtoRepository;
import com.gradleproject.demo_gradle.repository.ZaikoLocationRepository;
import com.gradleproject.demo_gradle.repository.ZaikoRepository;

@Service
public class ZaikoService {
	
	/***
	 * 在庫テーブルレポジトリ
	 */
	@Autowired
	private ZaikoRepository zaikoRepository;
	
	/***
	 * 在庫保管場所テーブルレポジトリ
	 */
	@Autowired
	private ZaikoLocationRepository zaikoLocationRepository;
	
	/***
	 * 在庫情報DTO レポジトリ
	 */
	@Autowired
	private ZaikoDtoRepository zaikoDtoRepository;
	
	/***
	 * 全検索
	 * @return
	 */
	public List<ZaikoDto> findAll() {
		return zaikoDtoRepository.selectAllZaikoData();
	}
	
	/***
	 * PKによる1件取得
	 * @param id
	 * @return
	 */
	public Zaiko findOne(Long id) {
		return zaikoRepository.findById(id).orElse(null);
	}
	
	/***
	 * 1件のデータ登録
	 * @param zaiko
	 * @return
	 */
	public ZaikoDto save(ZaikoDto zaikoDto) {
		
		Zaiko zaiko = new Zaiko();
		ZaikoLocation zaikoLocation = new ZaikoLocation();
		
		// DTOからエンティティへ詰め替え
		zaiko.setProductName(zaikoDto.getProductName());
		zaiko.setZaikosu(zaikoDto.getZaikosu());
		zaiko.setBiko(zaikoDto.getBiko());
		zaikoLocation.setLocationName(zaikoDto.getLocationName());
		
		// 在庫テーブル登録、登録後にIDを取得する
		zaiko = zaikoRepository.save(zaiko);
		
		// 外部キー設定
		zaikoLocation.setZaikoId(zaiko.getId());
		// 在庫保管場所テーブル登録
		zaikoLocationRepository.save(zaikoLocation);
		
		zaikoDto.setZaikoId(zaiko.getId());
		zaikoDto.setLocationId(zaikoLocation.getId());
		return zaikoDto;
	}
	
	/***
	 * テーブルのデータ件数
	 * @return
	 */
	public long count() {
		return zaikoRepository.count();
	}
	
	/***
	 * 全件削除
	 */
	public void deleteAll() {
		zaikoRepository.deleteAll();
	}
	
	/***
	 * PKによる1件削除
	 * @param id
	 */
	public void delete(Long id) {
		zaikoRepository.deleteById(id);
	}
	
	/***
	 * テストデータを100件登録する
	 */
	public void insertByTestData() {
		
		int num_of_record = 100;
		int count = (int)count();
		
		for (int i = 0 + count; i < num_of_record + count; i++) {
			Zaiko tmp = new Zaiko();
			ZaikoLocation tmp2 = new ZaikoLocation();
			
			tmp.setProductName("test-data-" + i);
			tmp.setZaikosu(i);
			tmp.setBiko("APIによる自動テストデータ挿入");
			tmp2.setLocationName("テスト場所" + i);
			
			tmp = zaikoRepository.save(tmp);
			tmp2.setZaikoId(tmp.getId());
			zaikoLocationRepository.save(tmp2);
		}
	}
	
	/***
	 * nativeクエリテスト
	 */
	public void executeNativeQuery() {
		zaikoRepository.selectAllByIdDesc();
		//zaikoRepository.selectAsterFromSomeTable();
	}
}
