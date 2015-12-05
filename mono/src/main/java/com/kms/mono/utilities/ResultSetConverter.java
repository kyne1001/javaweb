package com.kms.mono.utilities;

import java.sql.*;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class ResultSetConverter {

    public static JSONArray toJSONArray(ResultSet rs) throws SQLException, JSONException {
        JSONArray jsonArray = new JSONArray();
        ResultSetMetaData rsMetaData = rs.getMetaData();
        
        while (rs.next()) {
            JSONObject jsonObject = new JSONObject();
            int numColumns = rsMetaData.getColumnCount();
            for (int i = 1; i < numColumns + 1; i++) {
                String column_name = rsMetaData.getColumnName(i);
                int columnType = rsMetaData.getColumnType(i);
                if (columnType == java.sql.Types.ARRAY) {
                    jsonObject.put(column_name, rs.getArray(i));
                } else if (columnType == java.sql.Types.BIGINT) {
                    jsonObject.put(column_name, rs.getLong(i));
                } else if(rsMetaData.getColumnType(i)==java.sql.Types.BOOLEAN) {
                    jsonObject.put(column_name, rs.getBoolean(column_name));
                } else if(rsMetaData.getColumnType(i)==java.sql.Types.BLOB) {
                    jsonObject.put(column_name, rs.getBlob(column_name));
                } else if(rsMetaData.getColumnType(i)==java.sql.Types.DOUBLE) {
                    jsonObject.put(column_name, rs.getDouble(column_name)); 
                } else if(rsMetaData.getColumnType(i)==java.sql.Types.FLOAT) {
                    jsonObject.put(column_name, rs.getFloat(column_name));
                } else if(rsMetaData.getColumnType(i)==java.sql.Types.INTEGER) {
                    jsonObject.put(column_name, rs.getInt(column_name));
                } else if(rsMetaData.getColumnType(i)==java.sql.Types.NVARCHAR) {
                    jsonObject.put(column_name, rs.getNString(column_name));
                } else if(rsMetaData.getColumnType(i)==java.sql.Types.VARCHAR) {
                    jsonObject.put(column_name, rs.getString(column_name));
                } else if(rsMetaData.getColumnType(i)==java.sql.Types.TINYINT) {
                    jsonObject.put(column_name, rs.getInt(column_name));
                } else if(rsMetaData.getColumnType(i)==java.sql.Types.SMALLINT) {
                    jsonObject.put(column_name, rs.getInt(column_name));
                } else if(rsMetaData.getColumnType(i)==java.sql.Types.DATE) {
                    jsonObject.put(column_name, rs.getDate(column_name));
                } else if(rsMetaData.getColumnType(i)==java.sql.Types.TIMESTAMP) {
                   jsonObject.put(column_name, rs.getTimestamp(column_name));   
                } else {
                    jsonObject.put(column_name, rs.getObject(column_name));
                }
            }
            
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }
}
