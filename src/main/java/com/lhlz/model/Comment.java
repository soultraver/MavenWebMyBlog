package com.lhlz.model;

public class Comment {
    private int id;
    private String content;
    private int article_id;
    private String article_title;

    private String comment_created_at;

    public Comment() {
    }

    public Comment(int id, String content, int article_id, String article_title) {
        this.id = id;
        this.content = content;
        this.article_id = article_id;
        this.article_title = article_title;
    }

    public Comment(int id, String content, int article_id, String article_title , String comment_created_at) {
        this.id = id;
        this.content = content;
        this.article_id = article_id;
        this.article_title = article_title;
        this.comment_created_at = comment_created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }
    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }
    public String getComment_created_at() {
        return comment_created_at;
    }

    public void setComment_created_at(String comment_created_at) {
        this.comment_created_at = comment_created_at;
    }
}
