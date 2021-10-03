package com.lhlz.servlet;

import com.lhlz.model.Comment;
import com.lhlz.service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CommentServlet")
public class CommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        CommentService commentService = new CommentService();
        String action = request.getParameter("action");

        if(action.equals("getall")){
            try {
                List<Comment> comments = commentService.getComments();
                request.setAttribute("comments",comments);
                request.getRequestDispatcher(request.getContextPath() + "/admin/comment.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (action.equals("getarticle_comments")){
            int id = Integer.valueOf(request.getParameter("id"));
            try {
                List<Comment> comments = commentService.getArticle_Comments(id);
                request.setAttribute("comments",comments);
                request.getRequestDispatcher(request.getContextPath() + "/article.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (action.equals("visit")){
            try {
                Comment c = commentService.getComment(Integer.valueOf(request.getParameter("id")));
                request.setAttribute("c",c);
                request.getRequestDispatcher(request.getContextPath() + "/admin/visitcomment.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (action.equals("add")){
            try {
                Comment c = new Comment(commentService.getComment_id()+1,request.getParameter("content"),
                        Integer.valueOf(request.getParameter("article_id")),request.getParameter("article_title"));

                if (commentService.addComment(c)){
                    int id = Integer.valueOf(request.getParameter("article_id"));
                    request.getRequestDispatcher(request.getContextPath() + "/servlet/home?role=showblog&id=" + id).forward(request,response);
                }else {
                    System.out.println("fail");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(action.equals("delete")){
            String id = request.getParameter("id");
            System.out.println(id);
            try {
                if(commentService.deleteComment(Integer.valueOf(id))){

                    request.getRequestDispatcher(request.getContextPath() + "/success.jsp").forward(request,response);
                } else {
                    request.getRequestDispatcher(request.getContextPath() + "/error.jsp").forward(request,response);
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
