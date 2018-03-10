package com.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.user.bean.User;
import com.user.dao.UserDao;

public class UserDaoImpl implements UserDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 获取数据库连接
	public void getConnection() {
		try {
			Context ct = new InitialContext();
			DataSource ds = (DataSource) ct.lookup("java:comp/env/jdbc/mysql");
			conn = ds.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
	}

	// 释放资源
	public boolean closeResource() {
		try {
			if (null != rs) {
				rs.close();
			}
			if (null != pstmt) {
				pstmt.close();
			}
			if (null != conn) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public boolean findUser(User user) {
		boolean valid = false;
		try {
			getConnection();
			String sql = "select * from user where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, user.getName());
			rs = pstmt.executeQuery();
			if(rs.next()&&rs.getString("password").equals(user.getPassword())){
				valid = true;
				return valid;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeResource();
		}
		
		return valid;
	}

	@Override
	public boolean findUser(String name, String pwd) {
		boolean valid = false;
		try {
			getConnection();
			String sql = "select * from user where name = ? and password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()){
				valid = true;
				return valid;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeResource();
		}
		return valid;
	}

	@Override
	public User findUser(String name) {
		User u = null;
		System.out.print(name);
		try {
			getConnection();
			String sql = "select * from user where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);//1，2
			rs = pstmt.executeQuery(sql);
			if(rs.next()){
				u = new User();
				u.setId(rs.getString("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource();
		}
		return u;
	}

	@Override
	public List<User> findAllUsers() {
		List<User> list = new ArrayList<>();
		getConnection();
		
		try {
			String sql = "select * from user";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User u  = new User();
				u.setId(rs.getString(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeResource();
		}
		return list;
	}
	
}
