<%@ page import="business.ExpSevice" %>
<%@ page import="po.expert" %>
<%@ page import="java.util.List" %><%--
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
    <title>专家库管理</title>
    <script src="js/jquery-3.4.0.min.js" type="text/javascript"></script>
    <script src="js/各种js.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="css/2.css">
</head>

<body>
<div id="div1">
    <p id="p1" >甘肃省文化产业信息管理平台</p>
    <p id="p2">管理员，您好！</p>
</div>
<div id="div2">
    <ul>
        <li><a href="#" onclick="backToExpManaege()">专家库管理</a></li>
        <li><a href="#" onclick="backToProManager()">项目管理</a></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>
<div id="div6">
    <div id="div3">
        <p>专家列表</p>
    </div>


    <div id="div4">
        <div id="div5">
            <button id="button2" onclick="addExp()">新增</button>
            <button id="button4" onclick="updateExp()">编辑</button>
            <button id="button1" onclick="delExp()">删除</button>
            <button id="button3" onclick="distribute()">分配项目</button>
            <button id="button5" onclick="showExpPro()">显示专家所管理项目</button>
        </div>
        <div id="div7">
            <table id="table1" cellpadding="15px" cellspacing="2px">
                <tr id="tr1">
                    <td>序号</td>
                    <td>选择</td>
                    <td>姓名</td>
                    <td>专家类别</td>
                    <td>性别</td>
                    <td>民族</td>
                    <td>出生年月</td>
                    <td>工作单位</td>
                    <td>职务</td>
                    <td>工作部门</td>
                    <td>学科</td>
                    <td>研究方向</td>
                </tr>
                <c:set var="id" value="1" />
                <c:forEach items="${requestScope.List}" var="exp">
                        <c:if test="${exp.del == false}">
                            <tr id="tr2">
                                <td>${pageScope.id}</td>
                                <td><input type="radio" name="select"  value="${exp.identity}"></td>
                                <td>${exp.name}</td>
                                <td>${exp.classification_of_industry}</td>
                                <td>${exp.sex}</td>
                                <td>${exp.nation}</td>
                                <td>${exp.birth}</td>
                                <td>${exp.company}</td>
                                <td>${exp.job}</td>
                                <td>${exp.department}</td>
                                <td>${exp.sub}</td>
                                <td>${exp.rearch_dirction}</td>
                            </tr>
                            <c:set var="id" value="${pageScope.id + 1}" />
                        </c:if>
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
