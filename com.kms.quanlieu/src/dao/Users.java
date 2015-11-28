package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.User;

public class Users {

    public List<User> getUser() throws Exception {
        List<User> result = new ArrayList<User>();
        Class.forName("com.mysql.jdbc.Driver");
        String conString = "jdbc:mysql://localhost/students"; 
        Connection con = DriverManager.getConnection(conString, "root", "");
        PreparedStatement statement = con.prepareStatement("select * from users");
        ResultSet rs = statement.executeQuery();
        
        while (rs.next()) {
            int id = Integer.parseInt(rs.getString(1));
            String name = (rs.getString(2));
            result.add(new User(id, name));
        }
        
        con.close();
        
        return result;
    }
    
}
