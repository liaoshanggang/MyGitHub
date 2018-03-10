import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        PreparedStatement pst = null;
        String sql = "select * from employees";
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                for (int i = 1; i <6 ; i++) {
                    System.out.print(rs.getString(i )+" ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null!=rs)
                    rs.close();
                if(null!=pst)
                    pst.close();
                if(null!=conn)
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Hello World!");
    }
}
