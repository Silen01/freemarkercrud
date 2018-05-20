package com.liu.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by 26522 on 2018/5/20.
 */
public class DB {
    private static Connection conn;
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1/bz?useUnicode=true&characterEncoding=utf-8","root","root");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void closeConnection(){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
