﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
String path=request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function-manage.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>

<script type="text/javascript">
function udelete(a)
{

var url="<%=basePath%>Trends_deltrends.action?tid="+a;
jQuery.post(url,null,callback)
function callback(data)
{
if(data==1)
{
alert("删除成功")
window.location.href="<%=basePath%>Trends_shownewslist.action"
}
else
{
alert("删除失败")}
}
}
</script>
</head>
<body onload="time()">
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="/S4SSHib/CarInfo.action">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li ><a href="/S4SSHManager/admin/index.jsp">首页</a></li>
			<li><a href="/S4SSHManager/Manager_showalluser.action">用户</a></li>
			<li ><a href="/S4SSHManager/MgCar_showlist.action">商品</a></li>
			<li   ><a href="/S4SSHManager/Mgord_showallord.action">订单</a></li>
			<li ><a href="/S4SSHManager/Trends_showcom.action">留言</a></li>
			<li class="current"><a href="/S4SSHManager/Trends_showalltrends.action">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
管理员<a href="/S4SSHManager/MgUsIn_showdeauser.action?uid=${userinfo.UId }">${userinfo.UName }</a>您好，今天是<input type="text" name='time' id="time" style="border: 0px;background:#fc7e31" readonly size='16' />，欢迎回到管理后台。	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><em><a href="/S4SSHManager/admin/user-add.jsp">新增</a></em><a href="/S4SSHManager/Manager_showalluser.action">所有用户</a></dd>
			    <dd><em><a href="/S4SSHManager/admin/user-add.jsp">新增</a></em><a href="/S4SSHManager/Manager_showuser.action">普通用户</a></dd>
				<dd><em><a href="/S4SSHManager/admin/user-add.jsp">新增</a></em><a href="/S4SSHManager/Manager_showadmin.action">管理员</a></dd>
				<dt>汽车信息</dt>
				<dd><em><a href="/S4SSHManager/admin/brand-add.jsp">新增</a></em><a href="/S4SSHManager/Model_showbrand.action">品牌管理</a></dd>
				<dd><em><a href="/S4SSHManager/Model_addseries.action">新增</a></em><a href="/S4SSHManager/Model_showseries.action">车系管理</a></dd>
				<dd><em><a href="/S4SSHManager/admin/age-add.jsp">新增</a></em><a href="/S4SSHManager/Model_showage.action">车龄管理</a></dd>
				<dd><em><a href="/S4SSHManager/admin/price-add.jsp">新增</a></em><a href="/S4SSHManager/Model_showprice.action">车价管理</a></dd>
				<dd><em><a href="/S4SSHManager/admin/distance-add.jsp">新增</a></em><a href="/S4SSHManager/Model_showdistance.action">行驶距离管理</a></dd>
				<dd><em><a href="/S4SSHManager/admin/emsi-add.jsp	">新增</a></em><a href="/S4SSHManager/Model_showemsi.action">排放标准管理</a></dd>
				<dd><em><a href="/S4SSHManager/admin/type-add.jsp">新增</a></em><a href="/S4SSHManager/Model_showtype.action">车型管理</a></dd>				
				<dt>商品管理</dt>
				<dd><a href="/S4SSHManager/MgCar_showlist.action">所有商品</a></dd>
				<dd><a href="/S4SSHManager/MgCar_showzs.action">在售商品</a></dd>
				<dd><a href="/S4SSHManager/MgCar_showsh.action">审核中的商品</a></dd>
				<dd><a href="/S4SSHManager/MgCar_showxj.action">下架的商品</a></dd>
				<dd><a href="/S4SSHManager/MgCar_showwtg.action">审核未通过的商品</a></dd>
				<dt>订单管理</dt>
				<dd><a href="/S4SSHManager/Mgord_showallord.action">所有订单</a></dd>
				<dd><a href="/S4SSHManager/Mgord_showzzjy.action">中止交易申请</a></dd>
				<dd><a href="/S4SSHManager/Mgord_showjyz.action">正在交易</a></dd>
				<dd><a href="/S4SSHManager/Mgord_showjywc.action">出售完成</a></dd>
				<dt>留言管理</dt>
				<dd><a href="/S4SSHManager/Trends_showcom.action">留言管理</a></dd>
				<dt>私人定制</dt>
				<dd><a href="/S4SSHManager/Manager_showsrdz.action">私人定制</a></dd>
				<dd><a href="/S4SSHManager/Manager_showclzsrdz.action">处理中的私人定制</a></dd>
				<dd><a href="/S4SSHManager/Manager_showyclsrdz.action">已处理的私人定制</a></dd>
				<dt>企业动态消息管理</dt>
                <dd><em><a href="/S4SSHManager/admin/alltrend-add.jsp">新增</a></em><a href="/S4SSHManager/Trends_showalltrends.action">所有动态</a></dd>
				<dd><em><a href="/S4SSHManager/admin/allnews-add.jsp">新增</a></em><a href="/S4SSHManager/Trends_shownewslist.action">新闻管理</a></dd>
				<dd><em><a href="/S4SSHManager/admin/active-add.jsp">新增</a></em><a href="/S4SSHManager/Trends_showactive.action">活动管理</a></dd>
			    <dt>业务分析</dt>
			    <dd><a href="/S4SSHManager/admin/chaxunche.jsp">卖出车情况</a></dd>
			    <dd><a href="/S4SSHManager/admin/pricechaxun.jsp">交易额情况</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>新闻管理</h2>
		<div class="manage">
		<div style="width:750px; height:600px; overflow:scroll;">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>新闻标题</th>
					<th>新闻头图片</th>
					<th>新闻内容</th>
					<th>类型</th>
					<th>日期</th>
					<th>操作</th>
				</tr>
				<c:if test="${!empty trends }">
				<c:forEach var="trends" items="${trends }">
				<tr>
					<td class="first w4 c">${trends.value.trId }</td>
					<td>${trends.value.trTitle}</td>
					<td><img  width="200" src="${trends.value.trImg}"/></td>
					<td>${trends.value.trText}</td>
					<td>${trends.value.trType}</td>
					<td>${trends.value.trDate}</td>
					<td class="w1 c"><a href="Trends_upnews.action?tid=${trends.value.trId }">修改</a> <a onclick=" udelete(${trends.value.trId})">删除</a></td>
				</tr>
				
				</c:forEach>
				</c:if>
				
				
			</table>
			 <div class="pages"> <c:if test="${curPage > 1}">
					<a href="Trends_shownewslist.action?jumpPage=1">首页</a>&nbsp;&nbsp;&nbsp;
		 		<a href="Trends_shownewslist.action?jumpPage=${curPage - 1}">上一页</a>
				</c:if> <c:if test="${curPage <= 1}">
			 		首页&nbsp;&nbsp;&nbsp;上一页
		 		</c:if> &nbsp;&nbsp;&nbsp; <c:if test="${curPage < maxPage}">
					<a href="Trends_shownewslist.action?jumpPage=${curPage + 1}">下一页</a>
		 			&nbsp;&nbsp;&nbsp;
		 			<a href="Trends_shownewslist.action?jumpPage=${maxPage}">尾页</a>
				</c:if> <c:if test="${curPage >= maxPage}">
					下一页
		 			&nbsp;&nbsp;&nbsp;尾页		 		
		 		</c:if>
				&nbsp;&nbsp;总共${maxRowCount}行&nbsp;&nbsp;每页显示${rowsPrePage}行&nbsp;&nbsp;总共${maxPage}页&nbsp;&nbsp;&nbsp;&nbsp;当前为第${curPage}页</div>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010  All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
