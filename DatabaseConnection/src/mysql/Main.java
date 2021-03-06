package mysql;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String conString = "jdbc:mysql://localhost/students"; 
        Connection con = DriverManager.getConnection(conString, "root", "");
        PreparedStatement statement = con.prepareStatement("select * from users");
        ResultSet rs = statement.executeQuery();
        
        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2) + "\t" + rs.getString(3));
        }
        
        con.close();
    }

}
