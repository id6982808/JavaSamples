package com.gradleproject.demo_gradle.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyData {
	
	@Id
	protected Integer id;
	protected String name;
	protected String mail;
	protected String tel;
	protected int age;
	
	public MyData() {
		super();
	}
	
	public MyData(String name, String mail,
			String tel, int age) {
		super();
		this.name = name;
		this.mail = mail;
		this.tel = tel;
		this.age = age;
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
