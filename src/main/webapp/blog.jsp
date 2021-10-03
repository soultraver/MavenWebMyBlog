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
    <title>blog</title>
    <link rel="stylesheet" href="<%=context %>/css/blog.css"/>
    <link rel="stylesheet" href="<%=context %>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=context %>/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=context %>/css/pagination.css">
    <script src="<%=context %>/js/jquery.min.js"></script>
    <script src="<%=context %>/js/blog.js"></script>
    <script src="<%=context %>/js/bootstrap.min.js"></script>
    <script src="<%=context %>/js/jquery.pagination.js"></script>
    <style type="text/css">
        a:link {
            text-decoration: none;
        }

        a:visited {
            text-decoration: none;
        }

        a:hover {
            text-decoration: none;
        }

        a:active {
            text-decoration: none;
        }
    </style>

</head>

<body style="background: #e2e2e2 url(<%=context %>/img/home.jpg) no-repeat fixed center;
        background-size: cover;">
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
    <div id="top">
        <div class="info">
            <div class="bg-title">
                Lhlz's Blog
            </div>
            <div class="md-title">
                DEBUG THE WORLD
            </div>
        </div>
    </div>
    <div id="main">
            <div class="container main-inner">
                <div class="row">
                    <div class="article-wrap col-md-10 col-md-offset-1 col-xs-12">
                        <c:forEach items="${result }" var="article">
                            <article class="index-article">
                                <div class="post-info">
                                    <h2>
                                        <a href="<%=context %>/servlet/home?role=showblog&id=${article.id}">${article.title }</a>
                                    </h2>
                                    <div class="post-detial">
                                        <span>${article.title}</span>
                                        <span>${fn:substring(article.article_created_at,0,10)}</span>
                                    </div>
                                </div>
                                    <center>
                                        <button class="more">
                                            <a href="<%=context %>/servlet/home?role=showblog&id=${article.id}" style="color: #000;">
                                                Read More
                                            </a>
                                        </button>
                                    </center>
                            </article>
                        </c:forEach>
                        <div id="News-Pagination" ></div>
                    </div>
                </div>
            </div>
    </div>
    <footer>
        <div id="block">
            <span id="beian"></span>
            <span id="demo"></span>
        </div>
    </footer>
</div>
</body>

</html>