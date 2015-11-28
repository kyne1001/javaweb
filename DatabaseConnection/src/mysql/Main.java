package mysql;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Class.forName("com.mysql.jdbc.Driver");
        String conString = "jdbc:mysql://localhost/students"; 
        Connection con = DriverManager.getConnection(conString, "root", "");
        PreparedStatement statement = con.prepareStatement("select * from users");
        ResultSet rs = statement.executeQuery();
        
        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2) + "\t" + rs.getString(3));
        }
    }

}
