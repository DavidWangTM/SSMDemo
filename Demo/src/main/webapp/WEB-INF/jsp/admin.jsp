<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/7/14
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>后台</title>
</head>
<body>
<shiro:authenticated>用户已经登录显示此内容</shiro:authenticated>
<shiro:hasRole name="admin">
    这是admin角色登录：<shiro:principal></shiro:principal>
</shiro:hasRole>

<shiro:hasPermission name="user:*">
    有user:*权限信息
</shiro:hasPermission>

<shiro:hasPermission name="test:*">
    有test:*权限信息
</shiro:hasPermission>


<br>
登录成功
</body>
</html>
