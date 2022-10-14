package com.gradleproject.demo_gradle.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ZaikoLocation {
	
	/***
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/***
	 * 在庫保管場所
	 */
	@Size(max=50)
	private String locationName;
	
	/***
	 * 外部キー：在庫ID
	 */
	@NotNull
	private Long zaikoId;
}
