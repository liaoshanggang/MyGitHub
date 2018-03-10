package com.hr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.hr.dao.BaseDao;

public class BaseDaoImpl implements BaseDao{

	//获取数据库连接
	@Override
	public Connection getConnection() {
		Connection conn = null;
		try {
			Context ct = new InitialContext();
			DataSource ds = (DataSource) ct.lookup("java:comp/env/jdbc/mysql");
			conn = ds.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	//释放资源
	@Override
	public void closeResource(ResultSet rs, PreparedStatement pt,
			Connection conn) {
			try {
				if(null!=rs){
				rs.close();
				}
				if(null!=pt){
					pt.close();
				}
				if(null!=conn){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

}
