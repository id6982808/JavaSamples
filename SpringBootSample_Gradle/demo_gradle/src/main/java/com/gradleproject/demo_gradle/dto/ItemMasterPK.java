package com.gradleproject.demo_gradle.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ItemMasterPK implements Serializable {
	
	/***
	 * 複合PK 1 商品マスタID
	 */
	private Long itemMasterId;
	
	/***
	 * 複合PK 2 商品マスタコード
	 */
	private Long itemMasterCd;
}
