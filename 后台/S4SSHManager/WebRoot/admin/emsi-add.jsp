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
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/checkuser.js"></script>
<script type="text/javascript">
function chek(){
 var flag=false;
 var name=document.all("name");
 var dea=document.all("dea");
 if(name.value.length>0){
     flag=true;
     dea.style.display="none";
 }
else{
dea.innerHTML="<font color='red'>请输入排放标准名称</font>"
 dea.style.display="inline";

}
return flag;
}
 function chekCount(){
  var count=document.all("count");
 
  var div=document.all("d2");

  var flag=false;
  if(count.value.length>0){
    if( isNumber(count.value)){
  
      flag=true;
      div.style.display="none";
    }
    else{
    div.innerHTML="<font color='red'>请输入正整数</font>"
     div.style.display="inline";
    }
  }
  else{
  flag=true;
  div.style.display="none";
  }
  return flag;
 }
  function cheksub(){
  var flag=false;
  if(chekCount()&&chek()){
  flag=true;
  }
  return flag;
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
			<li class="current"><a href="/S4SSHManager/MgCar_showlist.action">商品</a></li>
			<li ><a href="/S4SSHManager/Mgord_showallord.action">订单</a></li>
			<li ><a href="/S4SSHManager/Trends_showcom.action">留言</a></li>
			<li ><a href="/S4SSHManager/Trends_showalltrends.action">新闻</a></li>
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
		<h2>新增排放标准</h2>
		<div class="manage">
			<form action="/S4SSHManager/Model_addemsi.action" method="post" onsubmit="return cheksub()">
				<input type="hidden" name="op" value="addemsi"/>
				<table class="form">
				<tr><td>排放标准名称:</td><td><input type="text" id="name" name="name" /><div id="dea" style="display: none;"></div></td></tr>
				<tr><td>热度</td><td colspan="4"><input type="text" id="count" name="count" onblur="chekCount()" /><div id="d2" >${mea }</div></td><td></td></tr>
				<tr><td>注</td><td>热度高的会在前台优先展示,不输入则记为0</td></tr>	
					
					<tr>
						<td><input type="hidden" id="cAge" name="cAge"/></td>
						<td><label class="ui-blue"><input type="submit"  value="添加"  /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010  All Rights Reserved. 京ICP证1000001号</div>
</body>
</html>
