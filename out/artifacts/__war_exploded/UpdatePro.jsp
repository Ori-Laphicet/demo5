<%@ page import="business.ProService" %>
<%@ page import="po.project" %><%--
  Created by IntelliJ IDEA.
  User: wqsdp2019
  Date: 2019/4/24
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>项目修改</title>
    <script src="js/jquery-3.4.0.min.js" type="text/javascript"></script>
    <script src="js/各种js.js" type="text/javascript"></script>
    <link rel="stylesheet" href="css/3.css" />
    <%
        String name =request.getParameter("name");
        ProService proService = new ProService();
        project pro = proService.findProByName(name);
    %>
</head>
<body>
<div id="div01">
    <p id="p01">项目修改(带*为必填项目)</p>
</div>
<form action="Project?param=update&name=<%=pro.getName()%>" method="post">
    <div id="div02">
        <div class="div001" ><span class="span1">项目名称</span></div>
        <div class="div007" style="padding-right:2px;"><input type="text" name="name" value="<%=name%>" required="required"></div><br>
        <div class="div001"><span class="span1" >联系人</span></div>
        <div class="div002"><input type="text" name="person" required="required" value="<%=pro.getPerson()%>"></div>
        <div class="div001"><span class="span1" >电子邮箱</span></div>
        <div class="div008"><input type="text" name="email" required="required" value="<%=pro.getEmail()%>"></div><br>
        <div class="div001"><span class="span1">固定电话</span></div>
        <div class="div002"><input type="text" name="tel" required="required" value="<%=pro.getTel()%>"></div>
        <div class="div001"><span class="span1">移动电话</span></div>
        <div class="div008"><input type="text" name="motel" required="required" value="<%=pro.getMotel()%>"></div><br>
        <div class="div001"><span class="span1">项目总资产</span></div>
        <div class="div002"><input type="text" name="money" required="required" value="<%=pro.getMoney()%>"></div>
        <div class="div001"><span class="span1">已完成投资</span></div>
        <div class="div008"><input type="text" name="gmoney" value="<%=pro.getGmoney()%>"></div><br>
        <div class="div001"><span class="span1">项目所处阶段</span></div>
        <div class="div007"style="padding-right:2px;">
            <input type="radio" name="stage" required="required" value="论证阶段">论证阶段
            <input type="radio" name="stage" required="required" value="启动阶段">启动阶段
            <input type="radio" name="stage" required="required" value="运行阶段">运行阶段
            <input type="radio" name="stage" required="required" value="项目结束">项目结束
        </div><br>
        <div class="div010"><span class="span1">项目主要内容</span></div>
        <div class="div009" style="padding-left:2px;"><input type="text" name="content" value="<%=pro.getContent()%>"></div>
        <div id="div03">
            <button class="button01" type="button" onclick="backToProManager()">取消</button>
            <button class="button02" type="submit">提交</button>
        </div>
    </div>
</form>
</body>
</html>
