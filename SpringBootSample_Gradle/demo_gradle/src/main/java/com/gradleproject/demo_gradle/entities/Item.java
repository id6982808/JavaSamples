package com.gradleproject.demo_gradle.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Item {
	
	@Id
	private Long id;
	
	@NotBlank(message="商品名を記入してください。")
	private String name;
	
	@Min(value=10, message="10以上の数値を入力してください。")
	@Max(value=10000, message="10000以下の数値を入力してください。")
	private float price;
	
	@Size(max=50, message="ベンダ名は50文字を超えないでください。")
	private String vendor;

}
