package com.forward.util;

import java.sql.*;

public class DatabaseConn {
    private static DatabaseConn databaseConn = new DatabaseConn();
    private static Connection connection = null;
    private static PreparedStatement pst = null;
    private static ResultSet rs = null;

    private DatabaseConn(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConn getInstance(){
        return databaseConn;
    }

    public static Connection getConnection(){
        try {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(ResultSet rs,PreparedStatement pst,Connection connection){
        try {
            if(rs!=null){
                rs.close();
            }
            if(pst!=null){
                pst.close();
            }
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
