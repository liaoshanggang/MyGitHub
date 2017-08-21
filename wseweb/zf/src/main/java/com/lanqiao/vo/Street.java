package com.lanqiao.vo;

public class Street {

	private Integer id;
	private String name;
	public Street() {
		super();
	}
	public Street(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "District [id=" + id + ", name=" + name + "]";
	}
	
	
}
