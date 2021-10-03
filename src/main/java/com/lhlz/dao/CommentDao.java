package com.lhlz.dao;

import com.lhlz.model.Comment;
import com.lhlz.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {

    public List<Comment> getComments() throws Exception {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Comment> comments = new ArrayList<Comment>();
        String sql = "select c.id,c.content,c.article_id,a.title,c.created_at from comment c, article a where a.id = c.article_id";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()){
                Comment c = new Comment(rs.getInt("id"),rs.getString("content"), rs.getInt("article_id"),
                        rs.getString("title"),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp("created_at")));
                comments.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn,pstmt,rs);
        }

        return comments;
    }

    public List<Comment> getArticle_Comments(int id) throws Exception {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Comment> comments = new ArrayList<Comment>();
        String sql = "select id,content from comment where article_id = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();

            while (rs.next()){
                Comment c = new Comment();
                c.setId(rs.getInt("id"));
                c.setContent(rs.getString("content"));
                comments.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn,pstmt,rs);
        }
        return comments;
    }

    public Comment getComment(int id) throws Exception {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Comment c = null;
        String sql = "select c.id,c.content,c.article_id,a.title,c.created_at from comment c, article a where a.id = c.article_id and c.id = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();

            if(rs.next()){
                c = new Comment(rs.getInt("id"),rs.getString("content"), rs.getInt("article_id"),
                        rs.getString("title"),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp("created_at")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn,pstmt,rs);
        }

        return c;
    }

    public int getComment_id() throws Exception {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int id = 0;
        String sql = "select id from comment";

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

    public boolean addComment(Comment c) throws Exception {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        boolean flag = false;
        String sql = "insert into comment(id,content,article_id) values(?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,c.getId());
            pstmt.setString(2,c.getContent());
            pstmt.setInt(3,c.getArticle_id());
            pstmt.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn,pstmt);
        }
        return flag;
    }

    public boolean deleteComment(int id) throws Exception {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        boolean flag = false;
        String sql = "delete from comment where id = ?";

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

}
