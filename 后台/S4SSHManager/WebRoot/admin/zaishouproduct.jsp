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

<script>
function cardel(id)
{
url="<%=basePath%>MgCar_dellcar.action?cid="+id;
jQuery.post(url,null,callback)
function callback(data)
{
if(data==1)
{
alert("删除成功")
window.location.href="<%=basePath%>MgCar_showzs.action"
}
else
{
alert("删除失败")}
}
}
function cartypedel(id,a)
{url="<%=basePath%>car_del.action?cid="+id;
jQuery.post(url,null,callback)
function callback(data)
{
if(data==1)
{
alert("删除成功")
window.location.href="<%=basePath%>car_showcar.action?type="+a
}
else
{
alert("删除失败")}
}
}



</script>
<script type="text/javascript">

var xmlhttp = false;
function CreateXMLHttp(){
        try{
            xmlhttp = new XMLHttpRequest();  //尝试创建 XMLHttpRequest 对象，除 IE 外的浏览器都支持这个方法。
        }
        catch (e){
            try{
                xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");  //使用较新版本的 IE 创建 IE 兼容的对象（Msxml2.XMLHTTP）
            }
            catch (e){
                try{
                  xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); //使用较老版本的 IE 创建 IE 兼容的对象（Microsoft.XMLHTTP）。
                }
                catch (failed){
                      xmlhttp = false;  //如果失败则保证 request 的值仍然为 false。
                }
            }
        }
        return xmlhttp;
}

function sendRequest(sel){
 
  var brand=sel.value;
  var sel2=document.all("sel2");
  var cpp= document.all("cpp");
  
  if(sel.value!="选择品牌"){
   
  cpp.value=sel.options[sel.options.selectedIndex].text;
  var url = "<%=basePath%>Model.action?brand="+brand+"&nocahe="+new Date().getTime()+"";
  CreateXMLHttp();
  if(xmlhttp){
     xmlhttp.open("GET",url, true); 
     xmlhttp.onreadystatechange = getResult; 
     xmlhttp.send(null); 
  }
  }
  else{
   sel2.length=0;
   cpp.value="";
    sel2.options.add(new Option("请先选择品牌","0"))
   
  }
  
} 

function getResult(){
  if (xmlhttp.readyState == 4 && xmlhttp.status == 200){ //完成请求正确返回
     var data=xmlhttp.responseText;
     var json=eval("("+data+")");
     var sel2=document.all("sel2");
     sel2.length=0;
     sel2.options.add(new Option("请选择","0"))
     for(var i=0;i<json.length;i++){
      sel2.options.add(new Option(json[i].MName,json[i].MId));
     }
  }
}

function getcx(sel){
 var ccx= document.all("ccx");
 if(sel.value!="0"){
  ccx.value=sel.options[sel.options.selectedIndex].text;
 }
 else{
    ccx.value="";
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
			<li   ><a href="/S4SSHManager/Manager_showalluser.action">用户</a></li>
			<li class="current" ><a href="/S4SSHManager/MgCar_showlist.action">商品</a></li>
			<li  ><a href="/S4SSHManager/Mgord_showallord.action">订单</a></li>
			<li   ><a href="/S4SSHManager/Trends_showcom.action">留言</a></li>
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
		<h2>在售商品</h2>
		<div class="manage">
		<form action="/S4SSHManager/MgCar_showzswhere.action" method="post">
		<input type="hidden" name="op" value="showzswhere"/>
		 <select id="pp" onchange="sendRequest(this)">
		 <option value="选择品牌">选择品牌</option>
		 <c:forEach var="allbrand" items="${allbrand }">
		 <option value="${allbrand.value.BId }">${allbrand.value.BName }</option>
		 </c:forEach>
		 </select>
		 <input type="hidden" id="cpp" name="cpp"/>
		 <select  name="sel2" id="sel2" onchange="getcx(this)" >
                                        <option value="请选择">请先选择品牌</option>
                                    </select>
                                    <input type="submit" value="确定"/>
                                     <input type="hidden" id="ccx" name="ccx"/>
                                    <input type="hidden" name="url" value="admin/allproduct.jsp"/>;
                                    </form>
			<table class="list">
				<tr>
				    <th>卖家ID</th>
					<th>商品ID</th>
					<th>商品名称</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<c:if test="${!empty carMap }">
				<c:forEach var="carMap" items="${carMap }">
				<tr>
				<td>${carMap.UId }</td>
					<td class="first w4 c">${carMap.CId }</td>
					<td class="thumb" ><a target="_blank" href="/S4SSHib/CarInfo_showshdea.action?cid=${carMap.CId }&uid=${carMap.UId}"><img src="/S4SSHib/${carMap.CImg}" /></a><a target="_blank" href="/S4SSHib/CarInfo_showshdea.action?cid=${carMap.CId }&uid=${carMap.UId}">${carMap.CBrand } ${carMap.CSeries } ${carMap.CId }${carMap.CType }${carMap.CModel }</a></td>
					<td>${carMap.CState }</td>
					<td class="w1 c"> <input type="button" value="删除" onclick="cardel(${carMap.CId})"></input></td>
				</tr>
				</c:forEach>
				</c:if>
				
			</table>
			 <div class="pages" align="center"> <c:if test="${curPage > 1}">
					<a href="/S4SSHManager/MgCar_showzswhere.action?cpp=${pp }&ccx=${cx}&jumpPage=1">首页</a>&nbsp;&nbsp;&nbsp;
		 		<a href="/S4SSHManager/MgCar_showzswhere.action?cpp=${pp }&ccx=${cx}&jumpPage=${curPage - 1}&">上一页</a>
				</c:if> <c:if test="${curPage <= 1}">
			 		首页&nbsp;&nbsp;&nbsp;上一页
		 		</c:if> &nbsp;&nbsp;&nbsp; <c:if test="${curPage < maxPage}">
					<a href="/S4SSHManager/MgCar_showzswhere.action?cpp=${pp }&ccx=${cx}&jumpPage=${curPage + 1}">下一页</a>
		 			&nbsp;&nbsp;&nbsp;
		 			<a href="/S4SSHManager/MgCar_showzswhere.action?cpp=${pp }&ccx=${cx}&jumpPage=${maxPage}">尾页</a>
				</c:if> <c:if test="${curPage >= maxPage}">
					下一页
		 			&nbsp;&nbsp;&nbsp;尾页		 		
		 		</c:if>
				&nbsp;&nbsp;总共${maxRowCount}行&nbsp;&nbsp;每页显示${rowsPrePage}行&nbsp;&nbsp;总共${maxPage}页&nbsp;&nbsp;&nbsp;&nbsp;当前为第${curPage}页</div>
			
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010  All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
