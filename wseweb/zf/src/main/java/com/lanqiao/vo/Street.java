package com.lanqiao.vo;

public class Street {

	private Integer id;
	private String name;
	private District district;

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

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

}
