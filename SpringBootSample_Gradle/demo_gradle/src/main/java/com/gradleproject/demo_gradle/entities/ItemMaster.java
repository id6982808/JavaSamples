package com.gradleproject.demo_gradle.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.gradleproject.demo_gradle.dto.ItemMasterPK;

import lombok.Data;

@Entity
@Data
@IdClass(value=ItemMasterPK.class)
public class ItemMaster {
	
	/***
	 * 複合PK 1 商品マスタID
	 */
	@Id
	private Long itemMasterId;
	
	/***
	 * 複合PK 2 商品マスタコード
	 */
	@Id
	private Long itemMasterCd;
	
	/***
	 * 商品名
	 */
	private String itemName;
	
	/***
	 * 商品金額
	 */
	private Long itemPrice;
}
