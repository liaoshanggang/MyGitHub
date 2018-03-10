package com.forward.entity;

public class Emp {
	int empId;
	String firstName;
	String lastName;
	String email;
	String phoneNum;

	public Emp() {
		super();
	}

	public Emp(int empId, String firstName, String lastName, String email,
			String phoneNum) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNum = phoneNum;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", phoneNum="
				+ phoneNum + "]";
	}

}
