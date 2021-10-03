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
    <title>admin_addpost</title>
    <link rel="stylesheet" href="../css/manage.css"/>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/editormd.min.css">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/blog.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/editormd.min.js"></script>
    <script type="text/javascript">
        function beforeSubmit(form) {
            if (form.title.value == '') {
                alert('文章标题不能为空！');
                form.title.focus();
                return false;
            }
            if (form.test - editormd - markdown - doc.value == 0) {
                alert('文章内容不能为空！');
                form.category.focus();
                return false;
            }
            if (form.category.value == 0) {
                alert('文章类别不能为空！');
                form.category.focus();
                return false;
            }
            if (form.subtitle.value == '') {
                alert('文章摘要不能为空！');
                form.subtitle.focus();
                return false;
            }
            if (form.main_id.value == '') {
                alert('文章主分类不能为空！');
                form.subtitle.focus();
                return false;
            }
            return true;
        }
    </script>
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
                        <li class="current">撰写文章</li>
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
        <form class="form-inline" action="<%=context %>/servlet/article?action=add" method="post"
              onSubmit="return beforeSubmit(this);">
            <div id="edit" class="col-md-8 col-xs-12">
                <h3>撰写新文章</h3>
                <hr/>
                <input type="text" id="article-title" name="title" class="form-control" placeholder="在此处输入标题"
                       autocomplete="off" style="width:100%;">
                <div class="editormd" id="test-editormd">
                    <textarea class="editormd-markdown-textarea" name="md_content"></textarea>
                    <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
                    <textarea class="editormd-html-textarea" name="html_context"></textarea>
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
                    <h4>发布时间：</h4>
                    <input type="text" name="year" value="2021" size="4" maxlength="4" style="margin: 5px 0;">
                    - <input type="text" name="month" value="06" size="2" maxlength="2" style="margin: 5px 0;">
                    - <input type="text" name="day" value="24" size="2" maxlength="2" style="margin: 5px 0;"><br/>
                    @ <input type="text" name="hour" value="18" size="2" maxlength="2" autocomplete="off">
                    ： <input type="text" name="minute" value="30" size="2" maxlength="2" autocomplete="off"><br/>
                </div>
                <h4>摘要：</h4>
                <textarea name="subtitle" rows="7" class="form-control"></textarea>
                <h4>分类：</h4>
                    <select class="form-control" name="main_id_name" id="main_id">
                        <option value="0">一级分类</option>
                        <c:forEach items="${categories}" var="c">
                            <option value="${c.main_id_name }">${c.main_id_name }</option>
                        </c:forEach>
                    </select>
                    <select class="form-control" name="sub_id_name" id="sub_id">
                        <option value="0">二级分类</option>
                        <c:forEach items="${categories}" var="c">
                            <option value="${c.sub_id_name }">${c.sub_id_name }</option>
                        </c:forEach>
                    </select>
                <br>
                <button type="submit" class="btn btn-primary" style="float: left;margin:5px;">发布</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>