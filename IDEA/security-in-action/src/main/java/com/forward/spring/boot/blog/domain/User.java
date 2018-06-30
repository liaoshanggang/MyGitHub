package com.forward.spring.boot.blog.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@XmlRootElement// mediatype 转为xml
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //自增策略
	private Long id; //实体一个唯一标识
	private String name;
	private Integer age;

	protected User() {//防止直接使用
	}

	public User(Long id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("User [id=%d,name='%s',age=%d]",id , name ,age);
	}
	
	
}
