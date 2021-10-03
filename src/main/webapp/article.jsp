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
    <title>article</title>
    <link rel="stylesheet" href="<%=context %>/css/blog.css"/>
    <link rel="stylesheet" href="<%=context %>/css/page.css">
    <link rel="stylesheet" href="<%=context %>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=context %>/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=context %>/css/prism.css">
    <script src="<%=context %>/js/jquery.min.js"></script>
    <script src="<%=context %>/js/blog.js"></script>
    <script src="<%=context %>/js/bootstrap.min.js"></script>
    <script src="<%=context %>/js/prism.js"></script>
</head>
<body>
<div id="bar" class="scrollbar"></div>
<div id="gotop"></div>
<div id="switch">
    <div id="iconfixed">
        <div class="icon"></div>
    </div>
</div>
<div id="left-nav">
    <div class="author-nav">
        <img src="<%=context %>/img/avatar.jpg" alt="个人头像">
    </div>
    <div class="main-nav">
        <ul>
            <a href="<%=context %>/index.html">
                <li>返回主页</li>
            </a>
            <a href="<%=context %>/servlet/home?role=blog">
                <li>博客首页</li>
            </a>
            <a href="<%=context %>/about.html">
                <li>关于我</li>
            </a>
            <a href="<%=context %>/contact.html">
                <li>联系我</li>
            </a>
            <a href="<%=context %>/servlet/home?role=show">
                <li>控制台</li>
            </a>
        </ul>
    </div>
</div>
<div id="wrap">
    <div id="main">
        <div class="container main-inner">
            <div class="row">
                <div class="col-md-8 col-md-offset-2 col-xs-12">
                    <div class="single-title"><h2>${a.title }</h2></div>
                    <div class="single-info">
                        发表于${fn:substring(a.article_created_at,0,10)}&nbsp;|&nbsp;分类于${a.main_id_name }.${a.sub_id_name}</div>
                    <div class="single-content">${a.html_context }</div>
                    <br>
                    <div id="SOHUCS" sid="${a.id }"></div>
                </div>
                <div class="col-md-8 col-md-offset-2 col-xs-12">
                    <form role="form" action="<%=context%>/servlet/comment?action=add&article_id=${a.id}" method="post">
                        <textarea placeholder="欢迎评论" class="form-control" rows="3" name="content"></textarea>
                        <button type="submit" class="btn" style="float: right; margin: 5px">发表评论</button>
                        <input type="hidden" name="article_title" value="${a.title}">
                    </form>
                    <br>
                    <div style="border: 1px">
                        <h4>评论区:</h4>
                        <c:forEach items="${comments}" var="c" >
                            <textarea placeholder="欢迎评论" rows="1" style='overflow:auto; background-attachment: fixed; background-repeat: no-repeat; border-style: none;'>游客${c.id}：${c.content}</textarea>
                            <br>
                        </c:forEach>
                    </div>
                    <footer>
                        <div id="block">
                            <span id="beian"></span>
                            <span id="demo"></span>
                        </div>
                    </footer>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>