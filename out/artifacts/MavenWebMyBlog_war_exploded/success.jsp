<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String context = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + context + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>success</title>
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
                    <a href="#">
                        <li class="current">所有文章</li>
                    </a>
                    <a href="<%=context %>/admin/addarticle.jsp">
                        <li>撰写文章</li>
                    </a>
                    <a href="<%=context %>/servlet/CategoryServlet?action=getall">
                        <li>分类管理</li>
                    </a>
                    <a href="https://changyan.kuaizhan.com/">
                        <li>游客评论</li>
                    </a>
                    <a href="https://changyan.kuaizhan.com/">
                        <li>游客留言</li>
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
            <h4>成功啦!!!</h4><br>
            <a href="<%=context%>/servlet/home?role=show">
                <button type="button" class="btn btn-primary">返回主页面</button>
            </a>
        </div>
    </div>
</div>

</body>
</html>