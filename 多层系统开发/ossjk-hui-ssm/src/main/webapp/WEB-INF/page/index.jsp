<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/taglib.jsp"%>
<%@ taglib uri="http://www.jkoss.com/ossjktaglib/menu" prefix="jk"%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
<link rel="Bookmark" href="favicon.ico">
<link rel="Shortcut Icon" href="favicon.ico" />
<title>OSSJK管理后台 v1.1</title>
<jsp:include page="/WEB-INF/inc/common.jsp"></jsp:include>
</head>
<body>

	<jk:menu>
			[{
				"name": "系统管理",
				"icon": "&#xe62e;",
				"child": [
						{
							"name": "用户管理",
							"href": "${pageContext.request.contextPath}/system/user/list.do"
						},
						{
							"name": "角色管理",
							"href": "${pageContext.request.contextPath}/system/role/list.do"
						},
						{
							"name": "部门管理",
							"href": "${pageContext.request.contextPath}/system/organization/list.do"
						}
				]
			},
			{
				"name": "设备管理",
				"icon": "&#xe62e;",
				"child": [
						{
							"name": "设备等级入库",
							"href": "${pageContext.request.contextPath}/device/device/list.do"
						},
						{
							"name": "设备类型管理",
							"href": "${pageContext.request.contextPath}/device/devicetype/list.do"
						},
						{
							"name": "设备领用归还",
							"href": "${pageContext.request.contextPath}/device/devicereceive/list.do"
						},
						{
							"name": "设备报修",
							"href": "${pageContext.request.contextPath}/device/devicerepair/list.do"
						},
						{
							"name": "设备报废",
							"href": "${pageContext.request.contextPath}/device/devicesout/list.do"
						}
				]
			}
			
			]
	</jk:menu>
	<div class="Hui-admin-aside-mask"></div>
	<div class="Hui-admin-dislpayArrow">
		<a href="javascript:void(0);" onClick="displaynavbar(this)"> <i class="Hui-iconfont Hui-iconfont-left">&#xe6d4;</i> <i class="Hui-iconfont Hui-iconfont-right">&#xe6d7;</i>
		</a>
	</div>
	<section class="Hui-admin-article-wrapper">
		<!--_header 作为公共模版分离出去-->
		<header class="Hui-navbar">
			<div class="navbar">
				<div class="container-fluid clearfix">
					<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar">
						<ul class="clearfix">
							<li>超级管理员</li>
							<li class="dropDown dropDown_hover"><a href="#" class="dropDown_A">${sessionScope.user.name } <i class="Hui-iconfont">&#xe6d5;</i></a>
								<ul class="dropDown-menu menu radius box-shadow">
									<li><a href="javascript:;" onClick="myselfinfo()">个人信息</a></li>
									<!-- 	<li><a href="#">切换账户</a></li> -->
									<li><a href="#" onClick="logout()">退出</a></li>
								</ul></li>
							<!-- <li id="Hui-msg"><a href="#" title="消息"><span class="badge badge-danger">1</span><i class="Hui-iconfont" style="font-size: 18px">&#xe68a;</i></a></li> -->
							<li id="Hui-skin" class="dropDown dropDown_hover right"><a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size: 18px">&#xe62a;</i></a>
								<ul class="dropDown-menu menu radius box-shadow">
									<li><a href="javascript:;" data-val="default" title="默认（蓝色）">默认（深蓝）</a></li>
									<li><a href="javascript:;" data-val="black" title="黑色">黑色</a></li>
									<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
									<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
									<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
									<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
								</ul></li>
						</ul>
					</nav>
				</div>
			</div>
		</header>
		<div id="Hui-admin-tabNav" class="Hui-admin-tabNav">
			<div class="Hui-admin-tabNav-wp">
				<ul id="min_title_list" class="acrossTab clearfix" style="width: 241px; left: 0px;">
					<li class=""><span title="我的桌面" data-href="${pageContext.request.contextPath}/system/toDesktop.do">我的桌面</span><em></em></li>
				</ul>
			</div>
			<div class="Hui-admin-tabNav-more btn-group" style="display: none;">
				<a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a> <a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a>
			</div>
		</div>
		<div id="iframe_box" class="Hui-admin-article">
			<div class="show_iframe">
				<iframe id="iframe-welcome" data-scrolltop="0" scrolling="yes" frameborder="0" src="${pageContext.request.contextPath}/system/toDesktop.do"></iframe>
			</div>
		</div>
	</section>
	<div class="contextMenu" id="Huiadminmenu">
		<ul>
			<li id="closethis">关闭当前</li>
			<li id="closeall">关闭全部</li>
		</ul>
	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript">
	$(function() {
		$("body").Huitab({
			tabBar : ".navbar-wrapper .navbar-levelone",
			tabCon : ".Hui-aside .menu_dropdown",
			className : "current",
			index : 0,
		});
	});
	/*登出*/
	function logout() {
		layer.confirm('确认要退出吗？', function(index) {
			location.href = "${pageContext.request.contextPath}/system/logout.do";
		});
	}
	/*个人信息*/
	function myselfinfo() {
		layer_show("个人信息", "${pageContext.request.contextPath}/system/user/toUpdate.do?id=${sessionScope.user.id}", 800, 500);
	}

	if (self != top) {
		window.top.location.replace(self.location); //打开自己网站的页面
	}
</script>

</html>
