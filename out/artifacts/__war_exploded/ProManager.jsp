<%@ page import="business.ExpSevice" %>
<%@ page import="po.expert" %>
<%@ page import="java.util.List" %>
<%@ page import="business.ProService" %>
<%@ page import="po.project" %><%--
  Created by IntelliJ IDEA.
  User: wqsdp2019
  Date: 2019/4/24
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>项目管理</title>
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
        <li><a href="#" onclick="backToProManager()">项目管理</a></li>>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>
    <div id="div6">
    <div id="div3">
        <p>项目列表</p>
    </div>

    <div id="div4">
        <div id="div5">
            <button id="button3" onclick="addPro()">新增</button>
            <button id="button7" onclick="updatePro()">编辑</button>
            <button id="button1" onclick="delPro()">删除</button>
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
                    <c:if test="${pro.del == false && (pro.exp == null || pro.exp == '')}">
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
                    </c:if>
                </c:forEach>





















<%--
                <%
                   /* //查询未分配项目数据
                    ProService proService = new ProService();
                    List<project> list = proService.findAllPro();*/
                   List<project> list = (List<project>) request.getAttribute("List");
                    int id = 1;
                    for (project pro:list){

                        if(pro.getDel() == false && (pro.getExp() == null || pro.getExp().equals(""))){
                %>
                <tr id="tr2">
                    <td><%=id%></td>
                    <td><input type="radio" name="select" value="<%=pro.getName() %>"></td>
                    <td><%=pro.getName()%></td>
                    <td><%=pro.getContent()%></td>
                    <td><%=pro.getMoney()%></td>
                    <td><%=pro.getStage()%></td>
                    <td><%=pro.getDate()%></td>
                    <td><%=pro.getPerson()%></td>
                    <td><%=pro.getMotel()%></td>
                    <td><%=pro.getTel()%></td>
                </tr>
                <%
                        }else {
                            continue;
                        }
                        id++;
                    }
                %>--%>
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
