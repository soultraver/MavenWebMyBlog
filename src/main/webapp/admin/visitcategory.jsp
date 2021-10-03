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
    <title>admin_category</title>
    <link rel="stylesheet" href="../css/manage.css"/>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/font-awesome.min.css">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/blog.js"></script>
    <script src="../js/bootstrap.min.js"></script>
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
                        <li class="current">分类管理</li>
                    <a href="<%=context %>/servlet/comment?action=getall&forward=comment">
                        <li>游客评论</li>
                    </a>
                    <a href="<%=context %>/index.html">
                        <li>返回首页</li>
                    </a>
                </ul>
            </div>
        </div>
        <div id="list" class="col-md-10 col-xs-12">
            <h3>${c.main_id_name}-${c.sub_id_name}下的文章</h3>
            <hr/>
            <!-- 后台返回结果为空 -->
            <c:if test="${fn:length(articles) eq 0 }">
                <span>暂无文章</span><br><br>
                <a href="<%=context %>/servlet/category?action=getall&forward=category">
                    <button type="button" class="btn btn-danger">返回</button>
                </a>
            </c:if>
            <!-- 后台返回结果不为空 -->
            <c:if test="${fn:length(articles) gt 0 }">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>标题</th>
                        <th>简介</th>
                        <th>时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${articles }" var="a">
                    <tr>
                        <td><c:out value="${a.title }"></c:out></td>
                        <td><c:out value="${a.subtitle }"></c:out></td>
                        <td><c:out value="${a.article_created_at }"></c:out></td>
                        <td>
                            <a href="<%=context %>/servlet/category?action=getall&forward=move&a_id=${a.id}&a_title=${a.title}">
                                <button type="button" class="btn btn-primary">移动</button>
                            </a>
                        </td>
                        <td></td>
                    </tr>
                    </c:forEach>
                </table>
                <a href="<%=context %>/servlet/category?action=getall&forward=category">
                    <button type="button" class="btn btn-danger">返回</button>
                </a>
                <br>
                <div id="News-Pagination" style="float: right"></div>
            </c:if>

        </div>
    </div>
</div>
</div>
</body>
</html>