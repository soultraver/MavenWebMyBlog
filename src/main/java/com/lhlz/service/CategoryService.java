package com.lhlz.service;

import com.lhlz.dao.CategoryDao;
import com.lhlz.model.Article;
import com.lhlz.model.Category;
import java.util.List;


public class CategoryService {
    CategoryDao categoryDao;

    public CategoryService(){
        categoryDao = new CategoryDao();
    }

    public List<Category> getCategories() throws Exception {
        return categoryDao.getCategories();
    }

    public Category getCategory(int id) throws Exception {
        return categoryDao.getCategory(id);
    }

    public List<Article> getCategory_Articles(String main_id_name, String sub_id_name) throws Exception{
        return categoryDao.getCategory_Articles(main_id_name,sub_id_name);
    }

    public int getCategoryId() throws Exception {
        return categoryDao.getCategoryId();
    }

    public boolean addCategory(Category c) throws Exception {
        return categoryDao.addCategory(c);
    }

    public boolean deleteCategory_01(String main_id_name, String sub_id_name) throws Exception {
        return categoryDao.deleteCategory_01(main_id_name,sub_id_name);
    }

    public boolean deleteCategory_02(String main_id_name, String sub_id_name) throws Exception {
        return categoryDao.deleteCategory_02(main_id_name,sub_id_name);
    }

    public boolean moveArticle(int id, String main_id_name, String sub_id_name) throws Exception {
        return categoryDao.moveArticle(id,main_id_name,sub_id_name);
    }

}
