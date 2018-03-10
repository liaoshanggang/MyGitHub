package com.oracle.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	private static DBUtil dbUtil = new DBUtil();
	private static Connection conn = null;
	Context context = null;
	DataSource dSource = null;

	private DBUtil() {
		try {
			context = new InitialContext();
			dSource = (DataSource) context
					.lookup("java:/comp/env/jdbc/myoracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static DBUtil getInstance() {
		return dbUtil;
	}

	public Connection getConnection() {
		try {
			conn = dSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void close(Connection conn, PreparedStatement psts, ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (psts != null) {
			try {
				psts.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
