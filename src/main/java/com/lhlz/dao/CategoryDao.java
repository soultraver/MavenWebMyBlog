package com.lhlz.dao;

import com.lhlz.model.Article;
import com.lhlz.model.Category;
import com.lhlz.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    public List<Category> getCategories() throws Exception {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Category> categories = new ArrayList<Category>();
        String sql = "select * from category";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()){
                Category c = new Category(rs.getInt("id"),rs.getString("main_id_name"),
                        rs.getString("sub_id_name"),
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp("created_at")));
                categories.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn,pstmt,rs);
        }

        return categories;
    }

    public Category getCategory(int id) throws Exception {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Category c = null;
        String sql = "select * from category where id = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            if (rs.next()){
                c = new Category(rs.getInt("id"),rs.getString("main_id_name"),
                        rs.getString("sub_id_name"),rs.getString("created_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn,pstmt,rs);
        }

        return c;
    }

    public List<Article> getCategory_Articles(String main_id_name, String sub_id_name) throws Exception {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Article> articles = new ArrayList<Article>();
        String sql = "select id,title,subtitle,created_at from article where main_id_name = ? and sub_id_name = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,main_id_name);
            pstmt.setString(2,sub_id_name);
            rs = pstmt.executeQuery();

            while (rs.next()){
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setSubtitle(rs.getString("subtitle"));
                a.setArticle_created_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp("created_at")));
                articles.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn,pstmt,rs);
        }
        return articles;
    }

    public int getCategoryId() throws Exception {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int id = 0;
        String sql = "select id from category";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()){
                id = rs.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn,pstmt,rs);
        }
        return id;
    }

    public boolean addCategory(Category c) throws Exception {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        boolean flag = false;
        String sql = "insert into category values(?,?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,c.getId());
            pstmt.setString(2,c.getMain_id_name());
            pstmt.setString(3,c.getSub_id_name());
            pstmt.setString(4,c.getCatagory_created_at());
            pstmt.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn,pstmt);
        }

        return flag;
    }

    public boolean deleteCategory_01(String main_id_name, String sub_id_name) throws Exception {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        boolean flag = false;
        String sql = "delete from category where main_id_name = ? and sub_id_name = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,main_id_name);
            pstmt.setString(2,sub_id_name);
            pstmt.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn,pstmt);
        }
        return flag;
    }

    public boolean deleteCategory_02(String main_id_name, String sub_id_name) throws Exception {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        boolean flag = false;
        String sql = "delete a,c from article a,category c where a.main_id_name = c.main_id_name and a.sub_id_name = c.sub_id_name and " +
                "c.main_id_name = ? and c.sub_id_name = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,main_id_name);
            pstmt.setString(2,sub_id_name);
            pstmt.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn,pstmt);
        }
        return flag;
    }

    public boolean moveArticle(int id, String main_id_name, String sub_id_name) throws Exception {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        boolean flag = false;
        String sql = "update article set main_id_name = ?, sub_id_name = ? where id = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,main_id_name);
            pstmt.setString(2,sub_id_name);
            pstmt.setInt(3,id);
            pstmt.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn,pstmt);
        }
        return flag;
    }
}
