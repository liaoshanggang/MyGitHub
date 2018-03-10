package com.user.buzi.impl;

import java.util.List;

import com.user.bean.User;
import com.user.buzi.UserBuzi;
import com.user.dao.UserDao;
import com.user.dao.impl.UserDaoImpl;

public class UserBuziImpl implements UserBuzi {
	UserDao ud = null;
	
	public UserBuziImpl() {
		ud = new UserDaoImpl();
	}
	
	@Override
	public boolean login(User u) {
		return ud.findUser(u);
	}

	@Override
	public boolean login(String name, String pwd) {
		return ud.findUser(name, pwd);
	}

	@Override
	public User getUser(String name) {
		return ud.findUser(name);
	}

	@Override
	public List<User> getAllUSers() {
		return ud.findAllUsers();
	}

}
