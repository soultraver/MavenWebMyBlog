<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>admin_login</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
</head>
<body>
<div id="main">
    <div class="container wrap">
        <div class="row col-md-4 col-md-offset-4">
            <form action="/servlet/login" method="post">
                <h2>控制台</h2>
                <input type="text" id="username" class="form-control" placeholder="用户名" name="username" />
                <input type="password" id="password" class="form-control" placeholder="密码" name="password" />

                <button class="btn btn-lg btn-primary btn-block" type="submit" id="submit">登录</button>
                <a href="<%=path%>/index.html">返回博客</a>
            </form>

        </div>
    </div>
</div>
</body>
</html>