package com.kms.mono.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Students {
    private static final String conString = "jdbc:mysql://localhost/students";
    
    public static int addStudents(
            String name, int age, boolean gender, int classId) throws Exception {
        
        int httpStatusCode = 200;
        Connection con = null;
        try {
            String sql = "insert into students (Name, Age, Gender, ClassId) values (?, ?, ?, ?)";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(conString, "root", "");
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setBoolean(3, gender);
            statement.setInt(4, classId);
            
            statement.executeUpdate();
            statement.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            httpStatusCode = 500;
        } finally {
            if (con != null) { con.close(); }   
        }
        
        return httpStatusCode;
    }
}
