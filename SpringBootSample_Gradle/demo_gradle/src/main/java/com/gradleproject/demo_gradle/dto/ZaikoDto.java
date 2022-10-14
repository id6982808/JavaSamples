package com.gradleproject.demo_gradle.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ZaikoDto {
	
	/***
	 * 在庫テーブルID
	 */
	@Id
	//@Column(name="zaiko_id")
	private Long zaikoId;
	
	/***
	 * 在庫保管場所テーブルID
	 */
	//@Column(name="location_id")
	private Long locationId;
	
	/***
	 * 商品名
	 */
	@NotEmpty
	//@Column(name="product_name")
	private String productName;
	
	/***
	 * 在庫数
	 */
	@NotNull
	@Min(value=0)
	@Max(value=999)
	//@Column(name="zaikosu")
	private int zaikosu;
	
	/***
	 * 備考
	 */
	@Size(max=50)
	//@Column(name="biko")
	private String biko;
	
	/***
	 * 在庫保管場所
	 */
	@Size(max=50)
	//@Column(name="location_name")
	private String locationName;
}
