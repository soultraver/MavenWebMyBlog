package com.lhlz.servlet;

import com.lhlz.model.Article;
import com.lhlz.model.Category;
import com.lhlz.service.ArticleService;
import com.lhlz.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet")
public class CategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        CategoryService categoryService = new CategoryService();

        String action = request.getParameter("action");
        String forward = request.getParameter("forward");

        if (action.equals("getall")){
            try {
                List<Category> categories = categoryService.getCategories();
                request.setAttribute("categories",categories);
                if(forward.equals("category")){
                    request.getRequestDispatcher(request.getContextPath()+"/admin/category.jsp").forward(request,response);
                } else if(forward.equals("addarticle")){
                    request.getRequestDispatcher(request.getContextPath()+"/admin/addarticle.jsp").forward(request,response);
                } else if(forward.equals("move")){
                    request.setAttribute("a_id",request.getParameter("a_id"));
                    request.setAttribute("a_title",request.getParameter("a_title"));
                    request.getRequestDispatcher(request.getContextPath()+"/admin/movearticle.jsp").forward(request,response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(action.equals("add")){
            try {
                int id = categoryService.getCategoryId()+1;
                Category c = new Category(id,request.getParameter("main_id_name"),
                        request.getParameter("sub_id_name"),request.getParameter("catagory_created_at"));
                if(categoryService.addCategory(c)){
                    request.getRequestDispatcher(request.getContextPath() + "/success.jsp").forward(request, response);
                }else {
                    request.getRequestDispatcher(request.getContextPath() + "/error.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(action.equals("visit")){
            try {
                Category c = categoryService.getCategory(Integer.valueOf(request.getParameter("id")));
                List<Article> articles = categoryService.getCategory_Articles(c.getMain_id_name(),c.getSub_id_name());
                request.setAttribute("c",c);
                request.setAttribute("articles",articles);
                request.getRequestDispatcher(request.getContextPath() + "/admin/visitcategory.jsp").forward(request,response);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (action.equals("move")){
            String a_id = request.getParameter("a_id");
            String main_id_name = request.getParameter("main_id_name");
            String sub_id_name = request.getParameter("sub_id_name");

            try {
                if (categoryService.moveArticle(Integer.valueOf(a_id),main_id_name,sub_id_name)){
                    request.getRequestDispatcher(request.getContextPath() + "/success.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher(request.getContextPath() + "/error.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(action.equals("delete")){
            String m_id_name = request.getParameter("m_id_name");
            String s_id_name = request.getParameter("s_id_name");

            try {
                if(categoryService.getCategory_Articles(m_id_name,s_id_name).size() == 0){
                    if (categoryService.deleteCategory_01(m_id_name,s_id_name)){
                        request.getRequestDispatcher(request.getContextPath() + "/success.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher(request.getContextPath() + "/error.jsp").forward(request, response);
                    }
                }else {
                    if (categoryService.deleteCategory_02(m_id_name,s_id_name)){
                        request.getRequestDispatcher(request.getContextPath() + "/success.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher(request.getContextPath() + "/error.jsp").forward(request, response);
                    }
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
