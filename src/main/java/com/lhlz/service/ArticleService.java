package com.lhlz.service;

import com.lhlz.dao.ArticleDao;
import com.lhlz.model.Article;

import java.util.List;

public class ArticleService {
    private ArticleDao articledao;

    public ArticleService() {
        articledao = new ArticleDao();
    }

    public List<Article> getArticles() throws Exception {
        return articledao.getArticles();
    }

    public Article getArticle(int id) throws Exception {
        return articledao.getArticle(id);
    }

    public int getArticle_id() throws Exception {
        return articledao.getArticle_id();
    }

    public boolean addArticle(Article a) throws Exception {
        return articledao.addArticle(a);
    }

    public boolean deleteArticle(int id) throws Exception {
        return articledao.deleteArticle(id);
    }

    public boolean updateArticle(Article a, int id) throws Exception {
        return articledao.updateArticle(a,id);
    }
}
