package com.lanqiao.vo;

public class UserInfo implements java.io.Serializable{
	private Integer userId;
	private String username;
	private String password;
	private String tel;
	private String email;

	public UserInfo() {
		super();
	}

	public UserInfo(Integer userId, String username, String password,
			String tel, String email) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.email = email;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", username=" + username
				+ ", password=" + password + ", tel=" + tel + ", email="
				+ email + "]";
	}

}
