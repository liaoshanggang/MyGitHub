package com.forward.dao;

import com.forward.po.User;
import com.forward.util.DatabaseConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoImpl {
    public DaoImpl() {
    }

    public User getUser(int user_id, String user_name, int password, double salary) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        User u = null;
        DatabaseConn databaseConn = DatabaseConn.getInstance();
        try {
			/*connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");*/
            connection = databaseConn.getConnection();

            String sql ="select user_id,user_name,password ,salary from atm_user where user_id = ? and user_name = ? and password = ? and salary = ?";

            pst = connection.prepareStatement(sql);
            pst.setInt(1, user_id);
            pst.setString(2, user_name);
            pst.setInt(3, password);
            pst.setDouble(4, salary);

            rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int pwd = rs.getInt(3);
                double sal = rs.getDouble(4);
                System.out.println(id+""+name+""+pwd+""+sal);
                u = new User(id, name, password, sal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            databaseConn.closeConnection(rs, pst, connection);
				/*try {
					if(rs!=null)
					rs.close();
					if(pst!=null)
						pst.close();
					if(connection!=null)
						connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
        }

        return u;
    }
}
