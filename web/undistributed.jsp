<%@ page import="po.project" %>
<%@ page import="business.ProService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sun.xml.internal.bind.v2.model.core.ID" %><%--
  Created by IntelliJ IDEA.
  User: wqsdp2019
  Date: 2019/4/24
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>为专家分配项目</title>
    <script src="js/jquery-3.4.0.min.js" type="text/javascript"></script>
    <script src="js/各种js.js" type="text/javascript"></script>
    <link rel="stylesheet" href="css/4.css" />
    <link rel="stylesheet" href="css/3.css" />
<%--    <%
        String ID = request.getParameter("id");

    %>--%>
</head>
<body>
<div id="div01">
    <p id="p01">分配项目</p>
</div>
<div id="div02">
    <table id="table2">
        <tr id="tr4">
            <td>序号</td>
            <td>选择</td>
            <td>项目名称</td>
            <td>项目所处阶段</td>
            <td>项目总资产</td>
        </tr>
        <c:set var="id" value="1" />
        <c:forEach items="${requestScope.List}" var="pro">
            <c:if test="${pro.del == false && (pro.exp == null || pro.exp == '')}" >
                <tr id="tr2">
                    <td>${pageScope.id}</td>
                    <td><input type="radio" name="select"  value="${pro.name}"></td>
                    <td>${pro.name}</td>
                    <td>${pro.stage}</td>
                    <td>${pro.money}</td>
                </tr>
                <c:set var="id" value="${pageScope.id + 1}" />
           </c:if>
        </c:forEach>


    </table>

    <%--以下内容是为解决<%=%>最后一位数会自动变为0的奇怪bug--%>
    <span id="111" hidden="hidden">${param.id}</span>
    <script>
        var I = $("#111").html();
    </script>
    <%--以上内容是为解决<%=%>最后一位数会自动变为0的奇怪bug--%>

    <div id="div03">
        <button class="button01" type="button" onclick="backToExpManaege()">取消</button>
        <button class="button02" type="button" onclick="distributePro(I)">确定</button>
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
</body>
</html>
