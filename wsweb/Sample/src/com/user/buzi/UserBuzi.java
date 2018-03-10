package com.user.buzi;

import java.util.List;

import com.user.bean.User;

public interface UserBuzi {
	//登录系统，输入User对象
	public boolean login(User u);
	
	//登录系统，输入用户名和密码字符串
	public boolean login(String name,String pwd);
	
	//根据用户名得到指定用户
	public User getUser(String name);
	
	//得到全部用户
	public List<User> getAllUSers();
}
