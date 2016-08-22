﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/showtime.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script>
function pass(cid,state)
{

var url="<%=basePath%>car.action?op=changestate&cid="+cid+"&state="+state;
jQuery.post(url,null,callback)
function callback(data)
{if(data==1)
{
alert('操作成功')
window.location.href="car.action?op=checking&state=审核"}
else
{
alert('操作失败')}
}
}

</script>
</head>
<body onload="time()">
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="user.jsp">用户</a></li>
			<li><a href="product.jsp">商品</a></li>
			<li class="current"><a href="order.jsp">订单</a></li>
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
		<h2>订单管理</h2>
		<div class="manage">
			<div class="search">
		<!--<form method="get">
					订单号：<input type="text" class="text" name="orderId" /> 订货人：<input type="text" class="text" name="userName" /> <label class="ui-blue"><input type="submit" name="submit" value="查询" /></label>
				</form> -->	
			</div>
			<div class="spacer"></div>
			<table class="list">
				<tr>
					<th>ID</th>
					<th>车辆信息</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<c:if test="${!empty shmap }">
				<c:forEach var="sm" items="${shmap }">
				<tr>
					<td class="first w4 c">${sm.value.c_id }</td>
					<td class="w1 c"><img src="${sm.value.c_img }"><a href="#">${sm.value.c_brand }${sm.value.c_series }</a></td>
					<td class="w1 c">${sm.value.c_state }</td>
					<td class="w1 c"><input type="button" value="通过" onclick="pass(${sm.value.c_id },'在售')"><input type="button" value="拒绝" onclick="pass(${sm.value.c_id },'审核失败')"></td>
				</tr>
				</c:forEach>
				</c:if>
				<c:if test="${!empty csmap }">
				<c:forEach var="cs" items="${csmap }">
				<tr>
					<td class="first w4 c">${cs.value.c_id }</td>
					<td class="w1 c"><img src="${cs.value.c_img }"><a href="#">${cs.value.c_brand }${cs.value.c_series }</a></td>
					<td class="w1 c">${cs.value.c_state }</td>
					<td class="w1 c"><input type="button" value="下架"></td>
				</tr>
				</c:forEach>
				</c:if>
				
				<c:if test="${!empty finishmap }">
				<c:forEach var="fm" items="${finishmap }">
				<tr>
					<td class="first w4 c">${fm.value.u_id }</td>
					<td class="w1 c"><img src="${fm.value.c_img }"><a href="#">${fm.value.c_brand }${fm.value.c_series }</a></td>
					<td class="w1 c">${fm.value.c_state }</td>
					<td class="w1 c"></td>
				</tr>
				</c:forEach>
				</c:if>
			</table>
			<div class="pager">
				<ul class="clearfix">
				<c:if test="${!empty csmaxPage }">
				<c:if test="${cspage>1 }">
					<li><a href="car.action?op=checking&page=${cspage-1}&state=在售">上一页</a></li>
					</c:if>
				<c:forEach var="i" begin="1" end="${csmaxPage }">
				<a href="car.action?op=checking&page=${i}&state=在售">${i}</a>
				</c:forEach>
				<c:if test="${cspage<csmaxPage }">
					<li><a href="car.action?op=checking&page=${cspage+1}&state=在售">下一页</a></li>
					</c:if>
				</c:if>
				<c:if test="${!empty shmaxPage }">
				<c:if test="${shpage>1 }">
					<li><a href="car.action?op=checking&page=${shpage-1}&state=审核">${shpage }上一页</a></li>
					</c:if>
				<c:forEach var="i" begin="1" end="${shmaxPage }">
				<a href="car.action?op=checking&page=${i}&state=审核">${i}</a>
				</c:forEach>
				<c:if test="${shpage<shmaxPage }">
					<li><a href="car.action?op=checking&page=${shpage+1}&state=审核">下一页</a></li>
					</c:if>
				</c:if>
				<c:if test="${!empty finishmaxPage }">
				<c:if test="${finishpage>1 }">
					<li><a href="car.action?op=checking&page=${finishpage-1}&state=交易完成">上一页</a></li>
					</c:if>
				<c:forEach var="i" begin="1" end="${finishmaxPage }">
				<a href="car.action?op=checking&page=${i}&state=交易完成">${i}</a>
				</c:forEach>
				<c:if test="${finishpage<finishmaxPage }">
					<li><a href="car.action?op=checking&page=${finishpage+1}&state=交易完成">下一页</a></li>
					</c:if>
				</c:if>
					
				</ul>
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
