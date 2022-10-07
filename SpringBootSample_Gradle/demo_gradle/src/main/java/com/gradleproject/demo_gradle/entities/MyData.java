package com.gradleproject.demo_gradle.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MyData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="name", nullable=false, length = 20)
	private String name;
	@Column(name="mail", nullable=false, length = 20)
	private String mail;
	@Column(name="tel", nullable=false, length = 20)
	private String tel;
	@Column(name="age", nullable=false)
	private int age;
	
	public MyData() {
		
	}
	
	public String toString() {
		return "[name:" + name + ", mail:" + mail + ", tel:" + tel + ", age:" + age + "]";
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getMail() {
		return mail;
	}
	
	public String getTel() {
		return tel;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}
