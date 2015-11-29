package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;

import utilities.ResultSetConverter;
import domain.User;

public class DataReader {

    private static final String conString = "jdbc:mysql://localhost/students";
    
    public static JSONArray getDataInJSONArray(String tableName) {
        JSONArray jSONArray = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(conString, "root", "");
            PreparedStatement statement = con.prepareStatement("select * from " + tableName);
            ResultSet rs = statement.executeQuery();
            jSONArray = ResultSetConverter.toJSONArray(rs);
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return jSONArray;
    }
    
    public static List<User> getUsers() {
        List<User> result = new ArrayList<User>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(conString, "root", "");
            PreparedStatement statement = con.prepareStatement("select * from users");
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = (rs.getString(2));
                result.add(new User(id, name));
            }
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
}
