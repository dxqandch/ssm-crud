<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/7 0007
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<jsp:forward page="/emps"/>

<html>
<head>
    <title>Title</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <%--以/开始的相对路径以服务器路径为标准（http：//localhost：3303）--%>
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.3.1/jquery-3.3.1.min.js"></script>
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>

</body>
</html>
