package com.ibeifeng.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ibeifeng.po.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	public void add(User user) {
		//getHibernateTemplate()
		this.getHibernateTemplate().save(user);
	}

	public void delete(User user) {

	}

	public List queryAll() {
		return null;
	}

	public User queryByID(String username) {
		//''varchar
		List list = this.getHibernateTemplate().find("select user from User user where user.username = '" + username + "'");
		
		if(list.size() == 0) {
			return null;
		} else {
			//获得username的值
			return (User)list.get(0);
		}
	}

	public void update(User user) {

	}

}
