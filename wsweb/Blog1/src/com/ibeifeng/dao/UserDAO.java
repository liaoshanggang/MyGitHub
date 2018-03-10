package com.ibeifeng.dao;

import java.util.List;

import com.ibeifeng.po.User;

public interface UserDAO {
	//添加用户
	public void add(User user);
	
	//删除用户
	public void delete(User user);
	
	//更新用户
	public void update(User user);
	
	//查询所有用户
	public List queryAll();
	
	//按id查询用户
	public User queryByID(String username);
}
