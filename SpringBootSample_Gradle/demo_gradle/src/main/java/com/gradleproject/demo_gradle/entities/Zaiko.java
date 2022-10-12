package com.gradleproject.demo_gradle.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class Zaiko {
	
	/***
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/***
	 * 商品名
	 */
	@NotEmpty
	private String productName;
	
	/***
	 * 在庫数
	 */
	@NotNull
	@Min(value=0)
	@Max(value=999)
	private int zaikosu;
	
	/***
	 * 備考
	 */
	@Size(max=50)
	private String biko;
}
