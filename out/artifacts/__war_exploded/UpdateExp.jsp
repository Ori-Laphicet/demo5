<%@ page import="com.sun.xml.internal.bind.v2.model.core.ID" %>
<%@ page import="business.ExpSevice" %>
<%@ page import="po.expert" %><%--
  Created by IntelliJ IDEA.
  User: wqsdp2019
  Date: 2019/4/19
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改专家信息</title>
    <script src="js/jquery-3.4.0.min.js" type="text/javascript"></script>
    <script src="js/各种js.js"></script>
    <link rel="stylesheet" href="css/3.css" />
    <%
        String ID =request.getParameter("ID");
        ExpSevice expSevice = new ExpSevice();
        expert exp = expSevice.findExpByIdentity(ID);
        System.out.println("来自updateexp.jsp"+ID);
    %>
</head>

<body>
<div id="div01">
    <p id="p01">专家修改(带*号为必填项)</p>
</div>
<form action="Expert?param=update&id=<%=ID%>&name=<%=exp.getName()%>" method="post">
    <div id="div02">
        <div class="div001"><span class="span1" >姓名&nbsp;*</span></div>
        <div class="div002"><input type="text" name="name" value="<%=exp.getName()%>" readonly="readonly"></div>
        <div class="div001"><span class="span1" >身份证号&nbsp;*</span></div>
        <div class="div003"><input type="text" name="identity" value="<%=ID%>" readonly="readonly"></div><br>
        <div class="div004"><span class="span1">性别</span></div>
        <div class="div002"><input type="radio" name="sex"  value="男">男<input type="radio" name="sex" value="女">女</div>
        <div class="div001"><span class="span1">民族</span></div>
        <div class="div003">
            <select  name="nation">
            <option value="汉族">汉族</option>
            <option value="蒙古族">蒙古族</option>
            <option value="回族">回族</option>
            <option value="藏族">藏族</option>
            <option value="维吾尔族">维吾尔族</option>
            <option value="苗族">苗族</option>
            <option value="彝族">彝族</option>
            <option value="壮族">壮族</option>
            <option value="布依族">布依族</option>
            <option value="朝鲜族">朝鲜族</option>
            <option value="满族">满族</option>
            <option value="侗族">侗族</option>
            <option value="瑶族">瑶族</option>
            <option value="白族">白族</option>
            <option value="土家族">土家族</option>
            <option value="哈尼族">哈尼族</option>
            <option value="哈萨克族">哈萨克族</option>
            <option value="傣族">傣族</option>
            <option value="黎族">黎族</option>
            <option value="傈僳族">傈僳族</option>
            <option value="佤族">佤族</option>
            <option value="畲族">畲族</option>
            <option value="高山族">高山族</option>
            <option value="拉祜族">拉祜族</option>
            <option value="水族">水族</option>
            <option value="东乡族">东乡族</option>
            <option value="纳西族">纳西族</option>
            <option value="景颇族">景颇族</option>
            <option value="柯尔克孜族">柯尔克孜族</option>
            <option value="土族">土族</option>
            <option value="达斡尔族">达斡尔族</option>
            <option value="仫佬族">仫佬族</option>
            <option value="羌族">羌族</option>
            <option value="布朗族">布朗族</option>
            <option value="撒拉族">撒拉族</option>
            <option value="毛南族">毛南族</option>
            <option value="仡佬族">仡佬族</option>
            <option value="锡伯族">锡伯族</option>
            <option value="阿昌族">阿昌族</option>
            <option value="普米族">普米族</option>
            <option value="塔吉克族">塔吉克族</option>
            <option value="怒族">怒族</option>
            <option value="乌孜别克族">乌孜别克族</option>
            <option value="俄罗斯族">俄罗斯族</option>
            <option value="鄂温克族">鄂温克族</option>
            <option value="德昂族">德昂族</option>
            <option value="保安族">保安族</option>
            <option value="裕固族">裕固族</option>
            <option value="京族">京族</option>
            <option value="塔塔尔族">塔塔尔族</option>
            <option value="独龙族">独龙族</option>
            <option value="鄂伦春族">鄂伦春族</option>
            <option value="赫哲族">赫哲族</option>
            <option value="门巴族">门巴族</option>
            <option value="珞巴族">珞巴族</option>
            <option value="基诺族">基诺族</option>
        </select>
        </div><br>
        <div class="div004"><span class="span1">出生年月</span></div>
        <div class="div002"><input type="text" name="birth" value="<%=exp.getBirth()%>"></div>
        <div class="div001"><span class="span1">单位&nbsp;*</span></div>
        <div class="div003"><input type="text" name="company" required="required" value="<%=exp.getCompany()%>"></div><br>
        <div class="div004"><span class="span1">工作部门&nbsp;*</span></div>
        <div class="div002"><input type="text" name="department" required="required" value="<%=exp.getDepartment()%>"></div>
        <div class="div001"><span class="span1">学科</span></div>
        <div class="div003"><input type="text" name="sub" value="<%=exp.getSub()%>"></div><br>
        <div class="div004"><span class="span1">职务职称</span></div>
        <div class="div002"><input type="text" name="job" value="<%=exp.getJob()%>"></div>
        <div class="div001"><span class="span1">研究方向&nbsp;*</span></div>
        <div class="div003"><input type="text" name="rearch_dirction" required="required" value="<%=exp.getRearch_dirction()%>"></div><br>
        <div class="div004"><span class="span1">行业分类&nbsp;*</span></div>
        <div class="div002"><input type="text" name="classification_of_industry" required="required" value="<%=exp.getClassification_of_industry()%>"></div>
        <div class="div001"><span class="span1">联系电话&nbsp;*</span></div>
        <div class="div003"><input type="text" name="tel" required="required" value="<%=exp.getTel()%>"></div><br>
        <div class="div004"><span class="span1">邮箱&nbsp;*</span></div>
        <div class="div002"><input type="text" name="email" required="required" value="<%=exp.getEmail()%>"></div>
        <div class="div001"><span class="span1">地址</span></div>
        <div class="div003"><input type="text" name="add" value="<%=exp.getAdd()%>"></div><br>
        <div class="div005">主要成就</div>
        <div class="div006"><input type="text" name="achievements" value="<%=exp.getAchievements()%>"></div><br>
        <div class="div005">荣誉奖励</div>
        <div class="div006"><input type="text" name="honors" value="<%=exp.getHonors()%>"></div>
        <div id="div03">
            <button class="button01" type="button" onclick="backToExpManaege()">取消</button>
            <button class="button02" type="submit">提交</button>
        </div>
    </div>
</form>
</body>
</html>
