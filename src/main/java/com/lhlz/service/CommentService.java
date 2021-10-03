package com.lhlz.service;

import com.lhlz.dao.CommentDao;
import com.lhlz.model.Comment;

import java.util.List;

public class CommentService {
    private CommentDao commentDao;

    public CommentService() {
        commentDao = new CommentDao();
    }

    public List<Comment> getComments() throws Exception {
        return commentDao.getComments();
    }

    public List<Comment> getArticle_Comments(int id) throws Exception {
        return commentDao.getArticle_Comments(id);
    }

    public Comment getComment(int id) throws Exception {
        return commentDao.getComment(id);
    }

    public int getComment_id() throws Exception {
        return commentDao.getComment_id();
    }

    public boolean addComment(Comment c) throws Exception {
        return commentDao.addComment(c);
    }

    public boolean deleteComment(int id) throws Exception {
        return commentDao.deleteComment(id);
    }
}
