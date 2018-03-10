package com.hr.bean;

public class Employee {
	String id;
	String name;
	double minWage;
	double maxWage;
	
	public Employee() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMinWage() {
		return minWage;
	}

	public void setMinWage(double minWage) {
		this.minWage = minWage;
	}

	public double getMaxWage() {
		return maxWage;
	}

	public void setMaxWage(double maxWage) {
		this.maxWage = maxWage;
	}
	
}
