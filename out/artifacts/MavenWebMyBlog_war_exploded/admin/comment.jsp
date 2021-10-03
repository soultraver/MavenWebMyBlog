<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String context = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + context + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>admin_home</title>
    <link rel="stylesheet" href="../css/manage.css"/>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/pagination.css">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/blog.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/jquery.pagination.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div id="left-nav" class="col-md-2">
            <div class="author-nav">
                <img src="../img/avatar.jpg" alt="个人头像">
            </div>
            <div class="main-nav">
                <ul>
                    <a href="<%=context %>/servlet/home?role=show">
                        <li>所有文章</li>
                    </a>
                    <a href="<%=context %>/servlet/category?action=getall&forward=addarticle">
                        <li>撰写文章</li>
                    </a>
                    <a href="<%=context %>/servlet/category?action=getall&forward=category">
                        <li>分类管理</li>
                    </a>
                        <li>游客评论</li>
                    <a href="<%=context %>/index.html">
                        <li>返回首页</li>
                    </a>
                </ul>
            </div>
        </div>
        <div id="list" class="col-md-10 col-xs-12">
            <h3>管理</h3>
            <hr/>
            <!-- 后台返回结果为空 -->
            <c:if test="${fn:length(comments) eq 0 }">
                <span>暂无评论</span>
            </c:if>
            <!-- 后台返回结果不为空 -->
            <c:if test="${fn:length(comments) gt 0 }">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>游客称号</th>
                        <th>被评文章</th>
                        <th>评论时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${comments}" var="c">
                    <tr>
                        <td>游客<c:out value="${c.id }"></c:out></td>
                        <td><c:out value="${c.article_title }"></c:out></td>
                        <td><c:out value="${c.comment_created_at }"></c:out></td>
                        <td>
                            <a href="<%=context %>/servlet/comment?action=visit&id=${c.id }">
                                <button type="button" class="btn btn-primary">查看</button>
                            </a>
                            <a href="<%=context %>/servlet/comment?action=delete&id=${c.id }">
                                <button type="button" class="btn btn-danger">删除</button>
                            </a>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
                <br>
                <div id="News-Pagination" style="float: right"></div>
            </c:if>

        </div>
    </div>
</div>
</body>
</html>