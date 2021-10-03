package com.lhlz.dao;

import com.lhlz.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public boolean VerifyUser(String username, String password) throws Exception {
        boolean flag = false;

        Connection conn = DBUtil.getConnection();
        String sql = "select * from user where username = ? and password = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }

        return flag;
    }

}
