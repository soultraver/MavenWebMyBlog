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
<%
    if(session.getAttribute("username") == null) {
%>
<script type="text/javascript" language="javascript">
    alert("您还没有登录，请先登录");
    top.location.href="../login.jsp";
</script>
<%
    }
%>
<div class="container-fluid">
    <div class="row">
        <div id="left-nav" class="col-md-2">
            <div class="author-nav">
                <img src="../img/avatar.jpg" alt="个人头像">
            </div>
            <div class="main-nav">
                <ul>
                        <li class="current">所有文章</li>
                    <a href="<%=context %>/servlet/category?action=getall&forward=addarticle">
                        <li>撰写文章</li>
                    </a>
                    <a href="<%=context %>/servlet/category?action=getall&forward=category">
                        <li>分类管理</li>
                    </a>
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
            <h3>管理</h3>
            <hr/>
            <!-- 后台返回结果为空 -->
            <c:if test="${fn:length(result) eq 0 }">
                <span>查询的结果不存在</span>
            </c:if>
            <!-- 后台返回结果不为空 -->
            <c:if test="${fn:length(result) gt 0 }">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>标题</th>
                        <th>一级分类</th>
                        <th>二级分类</th>
                        <th>日期</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${result}" var="article">
                    <tr>
                        <td><c:out value="${article.title }"></c:out></td>
                        <td><c:out value="${article.main_id_name }"></c:out></td>
                        <td><c:out value="${article.sub_id_name }"></c:out></td>
                        <td><c:out value="${article.article_created_at }"></c:out></td>
                        <td>
                            <a href="<%=context %>/servlet/home?role=update&id=${article.id }">
                                <button type="button" class="btn btn-primary">修改</button>
                            </a>
                            <a href="<%=context %>/servlet/home?role=delete&id=${article.id }">
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