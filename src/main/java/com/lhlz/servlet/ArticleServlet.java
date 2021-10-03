package com.lhlz.servlet;

import com.lhlz.model.Article;
import com.lhlz.service.ArticleService;
import com.lhlz.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ArticleServlet")
public class ArticleServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        ArticleService articleService;
        articleService = new ArticleService();

        String action = request.getParameter("action");

        if("add".equals(action)){
            Article article = new Article();
            try {
                article.setId(articleService.getArticle_id()+1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            article.setTitle(request.getParameter("title"));
            article.setMd_content(request.getParameter("md_content"));
            article.setHtml_context(request.getParameter("html_context"));
            int top = request.getParameter("top") == null ? 0 : 1;
            article.setTop(top);
            String year = request.getParameter("year");
            String month = request.getParameter("month");
            String day = request.getParameter("day");
            String hour = request.getParameter("hour");
            String minute = request.getParameter("minute");
            String createdate = year + "-" + month + "-" + day + " " + hour + ":" + minute;
            article.setArticle_created_at(createdate);
            article.setSubtitle(request.getParameter("subtitle"));
            article.setMain_id_name(request.getParameter("main_id_name"));
            article.setSub_id_name(request.getParameter("sub_id_name"));
            try {
                if(articleService.addArticle(article)){
                    request.getRequestDispatcher(request.getContextPath() + "/success.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher(request.getContextPath() + "/error.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(action.equals("update")){
            Article article = new Article();
            String id = request.getParameter("id");
            article.setTitle(request.getParameter("title"));
            article.setMd_content(request.getParameter("md_content"));
            article.setHtml_context(request.getParameter("html_context"));
            int top = request.getParameter("top") == null ? 0 : 1;
            article.setTop(top);
            article.setSubtitle(request.getParameter("subtitle"));
            try {
                if(articleService.updateArticle(article,Integer.valueOf(id))){
                    request.getRequestDispatcher(request.getContextPath() + "/success.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher(request.getContextPath() + "/error.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
