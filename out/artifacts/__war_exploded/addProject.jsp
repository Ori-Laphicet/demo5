<%--
  Created by IntelliJ IDEA.
  User: wqsdp2019
  Date: 2019/4/24
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>项目申报</title>
    <script src="js/jquery-3.4.0.min.js" type="text/javascript"></script>
    <script src="js/各种js.js" type="text/javascript"></script>
    <link rel="stylesheet" href="css/3.css" />
</head>
<body>
<div id="div01">
    <p id="p01">项目申报(带*为必填项目)</p>
</div>
<form action="Project?param=add" method="post">
<div id="div02">
    <div class="div001"><span class="span1">项目名称&nbsp;*</span></div>
    <div class="div007" style="padding-right:2px;"><input type="text" name="name" required="required" ></div><br>
    <div class="div001"><span class="span1" >联系人&nbsp;*</span></div>
    <div class="div002"><input type="text" name="person" required="required"></div>
    <div class="div001"><span class="span1" >电子邮箱&nbsp;*</span></div>
    <div class="div008"><input type="text" name="email" required="required"></div><br>
    <div class="div001"><span class="span1">固定电话&nbsp;*</span></div>
    <div class="div002"><input type="text" name="tel" required="required"></div>
    <div class="div001"><span class="span1">移动电话&nbsp;*</span></div>
    <div class="div008"><input type="text" name="motel" required="required"></div><br>
    <div class="div001"><span class="span1">项目总资产(万元)&nbsp;*</span></div>
    <div class="div002"><input type="text" name="money" required="required"></div>
    <div class="div001"><span class="span1">已完成投资</span></div>
    <div class="div008"><input type="text" name="gmoney"></div><br>
    <div class="div001"><span class="span1">项目所处阶段&nbsp;*</span></div>
    <div class="div007"style="padding-right:2px;">
        <input type="radio" name="stage" required="required" value="论证阶段">论证阶段
        <input type="radio" name="stage" required="required" value="启动阶段">启动阶段
        <input type="radio" name="stage" required="required" value="运行阶段">运行阶段
        <input type="radio" name="stage" required="required" value="项目结束">项目结束
    </div><br>
    <div class="div010"><span class="span1">项目主要内容&nbsp;*</span></div>
    <div class="div009" style="padding-left:2px;"><input type="text" name="content" required="required"></div>
    <div id="div03">
        <button class="button01" type="button" onclick="backToProManager()">取消</button>
        <button class="button02" type="submit">提交</button>
    </div>
</div>
</form>
</body>
</html>
