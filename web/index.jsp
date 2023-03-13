<%--
  Created by IntelliJ IDEA.
  User: Ting
  Date: 2023/2/27
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
  <%--<head>--%>
    <%--<title>$Title$</title>--%>
  <%--</head>--%>
  <%--<body>--%>
  <%--河南科技大学豪杰--%>
  <%--</body>--%>
<%--</html>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>用户登录</title>
</head>
<body>
<form action="MyServlet1" method="post">
  <p>
    用户名：<input type="text" name="username">
  </p>
  <p>
    密    码：<input type="password" name="password">
  </p>
  <p>
    <input type="submit" value="登录">
  </p>
  <%
    String msg = (String)request.getAttribute("msg");
    if(msg != null && !"".equals(msg)) {
  %>
  <p style="color: red;">
    <%=msg %>
  </p>
  <% } %>
</form>
</body>
</html>