package com.lhlz.util;

import java.sql.*;

public class DBUtil {
    private static String url = "jdbc:mysql://127.0.0.1:3306/myblog";
    private static String username = "root";
    private static String password = "lhlz121314@";

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection(Connection conn, PreparedStatement pstmt){
        closeConnection(conn);
        if(pstmt != null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection(Connection conn, PreparedStatement pstmt, ResultSet rs){
        closeConnection(conn, pstmt);
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void test() {

    }
}
