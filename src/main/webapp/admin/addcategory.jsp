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
<body onload="getcurtime()">
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
                    <a href="<%=context %>/admin/addarticle.jsp">
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
            <h3>管理</h3>
            <hr/>

                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>一级分类</th>
                        <th>二级分类</th>
                        <th>日期</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>

                    <form action="<%=context %>/servlet/category?action=add" method="post">
                        <tr>
                            <td><input type="text" name="main_id_name"></td>
                            <td><input type="text" name="sub_id_name"></td>
                            <td><input type="text" name="catagory_created_at" id="currenttime"></td>
                            <script>
                                function getcurtime() {
                                    var today = new Date();
                                    var yyyy = today.getFullYear();
                                    var MM = today.getMonth() + 1;
                                    var dd = today.getDate();
                                    var hh = today.getHours();
                                    var mm = today.getMinutes();
                                    MM = checkTime(MM);
                                    dd = checkTime(dd);
                                    hh = checkTime(hh);
                                    mm = checkTime(mm);
                                    var time = yyyy + "-" + MM + "-" + dd + " " + hh + ":" + mm;

                                    var dateControl = document.querySelector("#currenttime");
                                    dateControl.value = time;

                                    function checkTime(i) {
                                        if (i < 10) {
                                            i = "0" + i;
                                        }
                                        return i;
                                    }
                                }
                            </script>
                            <td>
                                <button type="submit" class="btn btn-primary">新增</button>
                            </td>
                        </tr>

                    </form>

                </table>
                <br>
            <a href="<%=context %>/servlet/category?action=getall&forward=category">
                <button type="button" class="btn btn-danger">返回</button>
            </a>
                <div id="News-Pagination" style="float: right"></div>
        </div>
    </div>
</div>
</div>
</body>
</html>