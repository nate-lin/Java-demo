<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>我的桌面</title>
<jsp:include page="/WEB-INF/inc/common.jsp"></jsp:include>
</head>
<body>
	<div class="wap-container">
		<article class="Hui-admin-content clearfix">
			<div class="panel">
				<div class="panel-body">
					<p class="f-20 text-success">
						欢迎使用OSSJK管理后台<span class="f-14">v1.1</span>
					</p>
					<p>上次登录IP：${sessionScope.assetuser.loginip } 上次登录时间：${sessionScope.assetuser.logintime }</p>
					<table class="table table-border table-bordered table-bg mt-20">
						<thead>
							<tr>
								<th colspan="2" scope="col">服务器信息</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>JDK版本</td>
								<td><%=System.getProperties().getProperty("java.version")%></td>
							</tr>
							<tr>
								<td>处理器个数</td>
								<td><%=Runtime.getRuntime().availableProcessors()%></td>
							</tr>
							<tr>
								<td>总内存</td>
								<td><%=Runtime.getRuntime().totalMemory() / 1024 / 1024%>M</td>
							</tr>
							<tr>
								<td>剩余内存</td>
								<td><%=Runtime.getRuntime().freeMemory() / 1024 / 1024%>M</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</article>
		<footer class="footer Hui-admin-footer">
			<p>
				感谢jQuery、layer、laypage、Validform、UEditor、iconfont、Datatables、WebUploaded、icheck、highcharts、bootstrap-Switch<br> Copyright &copy;2018 <a href="http://www.ossjk.com/" target="_blank" title="OSSJK管理后台 v1.1">OSSJK管理后台 v1.1</a> All Rights Reserved.<br> 本后台系统由<a href="http://www.h-ui.net/" target="_blank" title="H-ui前端框架">H-ui前端框架</a>提供前端技术支持
			</p>
		</footer>
	</div>
</body>
</html>
