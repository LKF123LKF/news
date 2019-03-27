<%@ page import="com.kgc.dao.BaseDao" %>
<%@ page import="java.sql.Connection" %><%--
  Created by IntelliJ IDEA.
  User: Hello
  Date: 2019/3/26
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    BaseDao baseDao=new BaseDao();
    Connection conn=baseDao.getConnection2();
%>
<%=conn%>
</body>
</html>
