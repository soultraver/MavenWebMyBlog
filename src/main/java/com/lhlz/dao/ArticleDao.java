package com.lhlz.dao;

import com.lhlz.model.Article;
import com.lhlz.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {

    public List<Article> getArticles() throws Exception {
        List<Article> articles = new ArrayList<Article>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from article";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setSubtitle(rs.getString("subtitle"));
                a.setMd_content(rs.getString("md_content"));
                a.setHtml_context(rs.getString("html_content"));
                a.setSub_id_name(rs.getString("sub_id_name"));
                a.setMain_id_name(rs.getString("main_id_name"));
                a.setTop(rs.getInt("top"));
                a.setArticle_created_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp("created_at")));
                articles.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn,pstmt,rs);
        }
        return articles;
    }

    public Article getArticle(int id) throws Exception {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Article a = null;
        String sql = "select * from article where id = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                a = new Article();
                a.setId(id);
                a.setTitle(rs.getString("title"));
                a.setSubtitle(rs.getString("subtitle"));
                a.setMd_content(rs.getString("md_content"));
                a.setHtml_context(rs.getString("html_content"));
                a.setSub_id_name(rs.getString("sub_id_name"));
                a.setMain_id_name(rs.getString("main_id_name"));
                a.setTop(rs.getInt("top"));
                a.setArticle_created_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp("created_at")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn,pstmt,rs);
        }

        return a;
    }

    public int getArticle_id() throws Exception {
        int id = 0;
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select id from article";
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

    public boolean addArticle(Article a) throws Exception {
        boolean flag = false;
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "insert into article values(?,?,?,?,?,?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,a.getId());
            pstmt.setString(2,a.getTitle());
            pstmt.setString(3,a.getSubtitle());
            pstmt.setString(4,a.getMd_content());
            pstmt.setString(5,a.getHtml_context());
            pstmt.setString(6,a.getSub_id_name());
            pstmt.setString(7,a.getMain_id_name());
            pstmt.setInt(8,a.getTop());
            pstmt.setString(9,a.getArticle_created_at());
            pstmt.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn,pstmt);
        }

        return flag;
    }

    public boolean deleteArticle(int id) throws Exception {
        boolean flag = false;
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "delete from article where id = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn,pstmt);
        }

        return flag;
    }

    public boolean updateArticle(Article a, int id) throws Exception {
        boolean flag = false;
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "update article set title=?, subtitle=?, md_content=?, html_content=?, top=? where id = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,a.getTitle());
            pstmt.setString(2,a.getSubtitle());
            pstmt.setString(3,a.getMd_content());
            pstmt.setString(4,a.getHtml_context());
            pstmt.setInt(5,a.getTop());
            pstmt.setInt(6,id);
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
