<%--
  Created by IntelliJ IDEA.
  User: DavidWang
  Date: 16/7/21
  Time: 下午5:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<input type="text" id="error" value="${error}"/>

<h1>登录页</h1>
<form action="${pageContext.request.contextPath }/loginAdmin" method="post">
    <div>
        <input type="text" name="name" class="name" placeholder="name" autocomplete="off"/>
    </div>
    <div>
        <input type="password" name="password" class="password" placeholder="password" oncontextmenu="return false"
               onpaste="return false" />
    </div>

    <div style="text-align: left; margin-left: 10px;" id="vcode">
        <input type="text" name="vcode"   placeholder="Verification code" style="width: 110px; margin-left: -8px; margin-right: 8px;">
        <img src="/open/getGifCode.shtml" />
    </div>

    <button id="submit" type="submit">登录</button>
</form>

</body>
</html>
