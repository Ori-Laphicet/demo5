<%@ page import="business.ProService" %>
<%@ page import="po.project" %>
<%@ page import="java.util.List" %>
<%@ page import="business.ExpSevice" %>
<%@ page import="java.awt.*" %><%--
  Created by IntelliJ IDEA.
  User: wqsdp2019
  Date: 2019/4/25
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>专家所分配项目</title>
    <script src="js/jquery-3.4.0.min.js" type="text/javascript"></script>
    <script src="js/各种js.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="css/2.css">

</head>
<body>
<%--以下内容是为解决<%=%>最后一位数会自动变为0的奇怪bug--%>
<span id="111" hidden="hidden">${requestScope.id}</span>
<script>
    var I = $("#111").html();
    console.log(I);
</script>
<%--以上内容是为解决<%=%>最后一位数会自动变为0的奇怪bug--%>



<div id="div6">
    <div id="div3">
        <p>项目展示</p>
    </div>
    <div id="div4">
        <div id="div5">
            <button onclick="backToExpManaege()">返回</button>
            <button onclick="UnAssign(I)">删除</button>
        </div>
        <div id="div7">
            <table id="table1" cellpadding="15px" cellspacing="2px">
                <tr id="tr1">
                    <td>序号</td>
                    <td>选择</td>
                    <td>项目名称</td>
                    <td>项目内容</td>
                    <td>申报金额(万元)</td>
                    <td>项目阶段</td>
                    <td>申请提交时间</td>
                    <td>提交人</td>
                    <td>联系方式</td>
                    <td>固定电话</td>
                </tr>
                <c:set var="id" value="1" />
                <c:forEach items="${requestScope.List}" var="pro">
                    <c:if test="${pro.name == null }">
                        <script>
                            alert("该专家没有项目");
                            window.location.href = "Expert?param=gotomanage";
                        </script>
                    </c:if>

                        <tr id="tr2">
                            <td>${pageScope.id}</td>
                            <td><input type="radio" name="select"  value="${pro.name}"></td>
                            <td>${pro.name}</td>
                            <td>${pro.content}</td>
                            <td>${pro.money}</td>
                            <td>${pro.stage}</td>
                            <td>${pro.date}</td>
                            <td>${pro.person}</td>
                            <td>${pro.motel}</td>
                            <td>${pro.tel}</td>
                        </tr>
                        <c:set var="id" value="${pageScope.id + 1}" />
                </c:forEach>

            </table>
        </div>
        <div id="pag_box">
            <a id="btn0"></a>
            <input id="pageSize" type="text" size="1" maxlength="2" value="getDefaultValue()"/><a> 条 </a> <a href="#" id="pageSizeSet">设置</a>&nbsp;
            <a id="sjzl"></a>&nbsp;
            <a  href="#" id="btn1">首页</a>
            <a  href="#" id="btn2">上一页</a>
            <a  href="#" id="btn3">下一页</a>
            <a  href="#" id="btn4">尾页</a>&nbsp;
            <a>转到&nbsp;</a>
            <input id="changePage" type="text" size="1" maxlength="4"/>
            <a>页&nbsp;</a>
            <a  href="#" id="btn5">跳转</a>
        </div>


    </div>
</div>

</body>
</html>
