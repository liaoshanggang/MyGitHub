package com.user.dao;

import java.util.List;

import com.user.bean.User;

public interface UserDao {
	//根据用户进行查找，返回是否查找到
	public boolean findUser(User user);
	
	//根据用户名和密码进行查找，返回是否查找到
	public boolean findUser(String name,String pwd);
	
	//根据用户名进行查找，返回查找到的用户
	public User findUser(String name);
	
	//返回所有用户的集合
	public List<User> findAllUsers();
}
