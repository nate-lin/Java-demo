<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>信息管理系统主界面</title>
<%
	// 权限验证
	if(session.getAttribute("currentUser")==null){
		response.sendRedirect("index.jsp");
		return;
	}
%>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
$(function(){
	// 数据
	var tree_westData=[{
		text:"职工信息管理",
		children:[{
			text:"系统信息管理",
			attributes:{
				url:"gradeInfoManage.jsp"
			}
		},{
			text:"内部信息管理",
			attributes:{
				url:"studentInfoManage.jsp"
			}
		}]
	
	}];
	
	// 实例化树菜单
	$("#tree_west").tree({
		data:tree_westData,
		lines:true,
		onClick:function(node){
			if(node.attributes){
				openTab(node.text,node.attributes.url);
			}
		}
	});
	
	// 新增Tab
	function openTab(text,url){
		if($("#tabs").tabs('exists',text)){
			$("#tabs").tabs('select',text);
		}else{
			var content="<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src="+url+"></iframe>";
			$("#tabs").tabs('add',{
				title:text,
				closable:true,
				content:content
			});
		}
	}
});

$(function(){
	// 数据
	var tree_eastData=[{
		text:"学生信息管理",
		children:[{
			text:"班级信息",
			attributes:{
				url:"gradeInfoManage.jsp"
			}
		},{
			text:"学生信息",
			attributes:{
				url:"studentInfoManage.jsp"
			}
		}]
	
	}];
	
	// 实例化树菜单
	$("#tree_east").tree({
		data:tree_eastData,
		lines:true,
		onClick:function(node){
			if(node.attributes){
				openTab(node.text,node.attributes.url);
			}
		}
	});
	
	// 新增Tab
	function openTab(text,url){
		if($("#tabs").tabs('exists',text)){
			$("#tabs").tabs('select',text);
		}else{
			var content="<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src="+url+"></iframe>";
			$("#tabs").tabs('add',{
				title:text,
				closable:true,
				content:content
			});
		}
	}
});
	
</script>
</head>
<body class="easyui-layout">
	<div region="north" style="height: 80px;background-color: #2b95ff">
		<div align="left" style="width: 80%;float: left"><img src="images/main.jpg"></div>
		<div style="padding-top: 50px;padding-right: 20px;font-weight:bold">当前用户：&nbsp;<font color="red" >${currentUser.userName }</font>
		<div align="right" style="float: right">
		<a href="index.jsp" style="text-decoration: none;color: #ffff80;font-weight:bold" >退出登录</a>
		</div>
		</div>
		
	</div>
	<div region="center" >
		<div class="easyui-tabs" fit="true" border="false" id="tabs">
			<div title="首页" >
				<iframe src="lunbo.jsp" width="100%" height="100%" frameborder="0" scrolling="no"></iframe>
				
			</div>
		</div>
	</div>
	<div region="west" style="width: 200px;" title="职工导航" split="true">	
		<ul id="tree_west"></ul>
	</div>
	<div region="east" style="width: 200px;" title="学生导航" split="true">	
		<ul id="tree_east"></ul>		
	</div>
	<div region="south" title="&nbsp;&nbsp;" split="true" style="height: 70px;padding-top:10px;" align="center">
		<div >
			<a href="wechat.jsp" style="text-decoration: none;">微信联系&nbsp;&nbsp;&nbsp;&nbsp;</a>
			&nbsp;&nbsp;&nbsp;&nbsp;作者：林春燕&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="reward.jsp" style="text-decoration: none;">&nbsp;&nbsp;&nbsp;&nbsp;打赏</a>
		</div>
	</div>
</body>
</html>