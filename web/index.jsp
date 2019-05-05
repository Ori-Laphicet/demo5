<%--
  Created by IntelliJ IDEA.
  User: spyry
  Date: 19/4/18
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
  <title>甘肃省文化产业发展专项自己信息管理平台</title>
  <script src="js/jquery-3.4.0.min.js" type="text/javascript"></script>
  <script src="js/各种js.js" type="text/javascript"></script>
  <link rel="stylesheet" type="text/css" href="css/1.css" />
</head>
<body class="div">
<div id="div1">
  <p id="p1">甘肃省文化产业发展专项资金信息管理平台</p>
</div>
<div id="div2">
  <div id="div3"></div>
  <div id="div4">
    <p id="p2">用户登录</p>
    <hr id="hr1">
    <form class="form1" action="login?param=is" method="post">
      <div id="div6">
        <label><b>账号：</b></label><br>
        <input type="text" name="account" placeholder="请填写用户名" required="required" /><br />
        <label><b>密码：</b></label><br>
        <input type="password" name="password" placeholder="请输入密码" required="required"/><br />
        <input type="text" name="text_code" placeholder="请输入验证码">
        <img src="#">
        <a href="#">换一张</a><br>
        <span id="error" ></span><br>
        <input type="checkbox" checked="checked" style="font-size: smaller;"> Remember me<br>
        <button type="submit" id="button1">登录</button><br>
      </div>
    </form>
  </div>
</div>
<div id="div5"><p id="p3">版权所有</p></div>

<c:if test="${sessionScope.LoginError == true}">
  <script>
    $("#error").html("账号或密码错误,请重新输入");
  </script>
  <c:remove var="LoginError" scope="session" />
</c:if>


</body>
</html>
