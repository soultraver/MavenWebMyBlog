package com.lhlz.model;

public class Article {
    private int id;
    private String title;
    private String subtitle;
    private String md_content;
    private String html_context;
    private String sub_id_name;
    private String main_id_name;
    private int top;
    private String article_created_at;

    public Article() {
    }

    public Article(int id, String title, String subtitle, String md_content, String html_context, String sub_id_name, String main_id_name, int top, String article_created_at) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.md_content = md_content;
        this.html_context = html_context;
        this.sub_id_name = sub_id_name;
        this.main_id_name = main_id_name;
        this.top = top;
        this.article_created_at = article_created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getMd_content() {
        return md_content;
    }

    public void setMd_content(String md_content) {
        this.md_content = md_content;
    }

    public String getHtml_context() {
        return html_context;
    }

    public void setHtml_context(String html_context) {
        this.html_context = html_context;
    }

    public String getSub_id_name() {
        return sub_id_name;
    }

    public void setSub_id_name(String sub_id_name) {
        this.sub_id_name = sub_id_name;
    }

    public String getMain_id_name() {
        return main_id_name;
    }

    public void setMain_id_name(String main_id_name) {
        this.main_id_name = main_id_name;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public String getArticle_created_at() {
        return article_created_at;
    }

    public void setArticle_created_at(String article_created_at) {
        this.article_created_at = article_created_at;
    }
}
