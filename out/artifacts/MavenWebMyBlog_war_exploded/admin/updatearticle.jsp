<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String context = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + context + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>admin_update</title>
    <link rel="stylesheet" href="../css/manage.css"/>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/editormd.min.css">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/blog.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/editormd.min.js"></script>
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
                        <li class="current">修改文章</li>
                </ul>
            </div>
        </div>
        <form class="form-inline" action="<%=context %>/servlet/article?action=update&id=${a.id}" method="post">
            <div id="edit" class="col-md-8 col-xs-12">
                <h3>修改文章</h3>
                <hr/>
                <input type="text" id="article-title" name="title" class="form-control" value="${a.title}"
                       autocomplete="off" style="width:100%;">
                <div class="editormd" id="test-editormd">
                    <textarea class="editormd-markdown-textarea" name="md_content">${a.md_content}</textarea>
                    <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
                    <textarea class="editormd-html-textarea" name="html_context">${a.html_context}</textarea>
                </div>
                <script type="text/javascript">
                    $(function () {
                        editormd("test-editormd", {
                            width: "100%",
                            height: 650,
                            syncScrolling: "single",
                            path: "admin/lib/",
                            //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
                            saveHTMLToTextarea: true
                        });
                    });
                </script>
            </div>
            <div id="operate" class="col-md-2 col-xs-12">
                <h3>操作</h3>
                <hr/>
                <div class="publish">
                    <h5><input type="checkbox" class="input-control" name="top" value="1">&nbsp;将该文章置顶</h5>
                    <h4>摘要：</h4>
                    <textarea name="subtitle" rows="7" class="form-control">${a.subtitle}</textarea><br>
                    <button type="submit" class="btn btn-primary" style="float: left;margin:5px;">修改</button>
                    <a href="<%=context %>/servlet/home?role=show">
                        <button type="button" class="btn btn-danger" style="float: left;margin:5px;">返回</button>
                    </a>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>