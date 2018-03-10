package com.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface BaseDao {
	public Connection getConnection();
	public void closeResource(ResultSet rs,PreparedStatement pt,Connection conn);
}
