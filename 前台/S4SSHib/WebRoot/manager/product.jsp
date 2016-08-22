﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/showtime.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
</head>
<script>
function cardel(id,a)
{url="<%=basePath%>car.action?op=del&cid="+id;
jQuery.post(url,null,callback)
function callback(data)
{
if(data==1)
{
alert("删除成功")
window.location.href="<%=basePath%>car.action?op=showcar&name="+a
}
else
{
alert("删除失败")}
}
}
function cartypedel(id,a)
{url="<%=basePath%>car.action?op=del&cid="+id;
jQuery.post(url,null,callback)
function callback(data)
{
if(data==1)
{
alert("删除成功")
window.location.href="<%=basePath%>car.action?op=showcar&type="+a
}
else
{
alert("删除失败")}
}
}



</script>
<body onload="time()">
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="user.jsp">用户</a></li>
			<li class="current"><a href="product.jsp">商品</a></li>
			<li><a href="order.jsp">订单</a></li>
			<li><a href="guestbook.jsp">留言</a></li>
			<li><a href="news.jsp">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员pillys您好，今天是<input type="text" name='time' id="time" style="border: 0px;background:#fc7e31" readonly size='15' >，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><em><a href="user-add.jsp">新增</a></em><a href="user.action?op=showuser">用户管理</a></dd>
				<dt>汽车信息</dt>
				<dd><em><a href="productClass-add.jsp">新增</a></em><a href="car.action?op=show">分类管理</a></dd>
				<dt>商品管理</dt>
				<dd><a href="guestbook.jsp">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="order.jsp">出售申请</a></dd>
				<dd><a href="order.jsp">正在交易</a></dd>
				<dd><a href="order.jsp">出售完成</a></dd>
				<dt>留言管理</dt>
				<dd><a href="guestbook.jsp">留言管理</a></dd>
				<dt>私人定制</dt>
				<dd><a href="guestbook.jsp">私人定制</a></dd>
				<dt>企业动态消息管理</dt>
				<dd><em><a href="news-add.jsp">新增</a></em><a href="news.jsp">动态管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>商品管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>商品名称</th>
					<th>操作</th>
				</tr>
				<c:if test="${!empty sbcar}">
				<c:forEach var="sbcar" items="${sbcar}">
				<tr>
					<td class="first w4 c">${sbcar.value.c_id }</td>
					<td class="thumb"><img src="${sbcar.value.c_img}" /><a href="#" target="_blank">${sbcar.value.c_brand } ${sbcar.value.c_series } ${sbcar.value.c_id }${sbcar.value.c_type }${sbcar.value.c_model }</a></td>
					<td class="w1 c"> <input type="button" value="删除" onclick="cardel(${sbcar.value.c_id},'${sbcar.value.c_brand }')"></td>
				</tr>
				</c:forEach>
				</c:if>
				<c:if test="${!empty tcarmap }">
				<c:forEach var="t" items="${tcarmap}">
				<tr>
					<td class="first w4 c">${t.value.c_id }</td>
					<td class="thumb"><img src="${t.value.c_img}" /><a href="#" target="_blank">${t.value.c_brand } ${t.value.c_series } ${t.value.c_id }${t.value.c_type }${t.value.c_model }</a></td>
					<td class="w1 c"> <input type="button" value="删除" onclick="cartypedel(${t.value.c_id},'${t.value.c_type }')"></td>
				</tr>
				</c:forEach>
				</c:if>
			</table>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010  All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
