package com.lanqiao.vo;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class Student {
	private Integer stuNo;
	private String stuName;
	private int stuAge;
	private Address address;
	// 通过form表单中的input字段来映射count属性时，合法输入：如1,234；不合法的输入：如12,34。
	@NumberFormat(pattern = "#,###")
	private int count;
	//规定birthday必须在当天之前、email必须符合邮箱格式。
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	@Email
	private String email;

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getStuNo() {
		return stuNo;
	}

	public void setStuNo(Integer stuNo) {
		this.stuNo = stuNo;
	}

	public Student(Integer stuNo, String stuName, int stuAge, Address address) {
		super();
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.address = address;
	}

	public Student(String stuName, int stuAge, Address address) {
		super();
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.address = address;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getStuAge() {
		return stuAge;
	}

	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

	public Address getAddress() {
		return address;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "学号：" + this.stuNo + "姓名:" + this.stuName + "\t年龄:"
				+ this.stuAge + "\t家庭地址：" + this.address.getHomeAddress()
				+ "\t学校地址：" + this.address.getSchoolAddress();
	}

}
