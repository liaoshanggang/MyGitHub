package com.ibeifeng.service;

import com.ibeifeng.dao.UserDAO;
import com.ibeifeng.po.User;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;
	
	public boolean registerUser(User user) {
		//判断用户是否存在
		if(userDAO.queryByID(user.getUsername()) != null) {
			return false;
		}else {//不存在，则是加入新用户
			userDAO.add(user);
			return true;
		}
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public boolean loginUser(User user) {
		//判断用户是否存在
		if(userDAO.queryByID(user.getUsername()) == null) {
			return false;
		} else {
			User queryUser = userDAO.queryByID(user.getUsername());
			if(queryUser.getPassword().equals(user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	

}
