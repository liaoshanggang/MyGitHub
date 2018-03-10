package com.forward.entity;

public class User {
	String username;
	String pwd;
	String repwd;
	String email;
	public User() {
		super();
	}
	public User(String username, String pwd, String repwd, String email) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.repwd = repwd;
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRepwd() {
		return repwd;
	}
	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", pwd=" + pwd + ", repwd="
				+ repwd + ", email=" + email + "]";
	}
	
}
