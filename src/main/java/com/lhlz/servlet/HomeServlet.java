package com.lhlz.servlet;

import com.lhlz.model.Article;
import com.lhlz.service.ArticleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet")
public class HomeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        ArticleService articleService = new ArticleService();
        String role =request.getParameter("role");

        try {
            List<Article> result = articleService.getArticles();
            request.setAttribute("result",result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(role.equals("show")){
            request.getRequestDispatcher(request.getContextPath() + "/admin/home.jsp").forward(request,response);
        } else if(role.equals("update")){
            try {
                String id = request.getParameter("id");
                Article article = articleService.getArticle(Integer.valueOf(id));
                request.setAttribute("a",article);
                request.getRequestDispatcher(request.getContextPath()+"/admin/updatearticle.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(role.equals("delete")){
            try {
                String id = request.getParameter("id");
                if (articleService.deleteArticle(Integer.valueOf(id))){
                    request.getRequestDispatcher(request.getContextPath() + "/admin/home.jsp").forward(request,response);
                } else {
                    request.getRequestDispatcher(request.getContextPath() + "/error.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(role.equals("blog")){
            request.getRequestDispatcher(request.getContextPath() + "/blog.jsp").forward(request,response);

        } else if(role.equals("showblog")){
            String id = request.getParameter("id");
            try {
                Article a = articleService.getArticle(Integer.valueOf(id));
                request.setAttribute("a",a);
                request.getRequestDispatcher(request.getContextPath() + "/servlet/comment?action=getarticle_comments&id=" + a.getId()).forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }
}
