<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/taglib.jsp"%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
<title>添加</title>
<jsp:include page="/WEB-INF/inc/common.jsp"></jsp:include>
</head>
<body style="background-color: #fff">
	<div class="wap-container">
		<div class="panel">
			<div class="panel-body">
				<form action="${pageContext.request.contextPath}/device/devicerepair/repair.do" method="post" class="form form-horizontal" id="form">
					<!-- 隐藏表单 -->
					<c:if test="${requestScope.record != null }">
						<input type="hidden" name="id" value="${requestScope.record.id }">
					</c:if>
					<div class="row clearfix">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>设备信息：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<select class="input-text" id="did" name="did" onfocus="this.defaultIndex=this.selectedIndex;" onchange="this.selectedIndex=this.defaultIndex;">
							   <option value="0">--请选择--</option>
							   <c:forEach items="${requestScope.devices}" var="device">
							       <option value="${device.id}" ${requestScope.record.did eq device.id?"selected":"" }>${device.code}-${device.dname}-${device.brand}-${device.model}</option>
							   </c:forEach>
							</select>
						</div>
					</div>
					<div class="row clearfix">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>报修人：</label>
						<div class="formControls col-xs-8 col-sm-9">
						   <select class="input-text" id="damager" name="damager" onfocus="this.defaultIndex=this.selectedIndex;" onchange="this.selectedIndex=this.defaultIndex;" >
							   <option value="0">--请选择--</option>
							   <c:forEach items="${requestScope.users}" var="user">
							       <option value="${user.id}" ${requestScope.record.damager eq user.id?"selected":"" }>${user.name}</option>
							   </c:forEach>
							</select>
						</div>
					</div>
					<div class="row clearfix">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>报修时间：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text" value="<fmt:formatDate value="${requestScope.record.damagedate }" pattern="yyyy-MM-dd"/>" placeholder="" id="damagedate" name="damagedate">
						</div>
					</div>
					<div class="row clearfix">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>报修备注：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text" value="${requestScope.record.damageremarks }" placeholder="" id="damageremarks" name="damageremarks">
						</div>
					</div>
					<div class="row clearfix">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>维修人：</label>
						<div class="formControls col-xs-8 col-sm-9">
							 <select class="input-text" id="repairer" name="repairer" onfocus="this.defaultIndex=this.selectedIndex;" onchange="this.selectedIndex=this.defaultIndex;" >
							   <option value="0">--请选择--</option>
							   <c:forEach items="${requestScope.users}" var="user">
							       <option value="${user.id}" ${requestScope.record.damager eq user.id?"selected":"" }>${user.name}</option>
							   </c:forEach>
							</select>
						</div>
					</div>
					
					<div class="row clearfix">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>维修日期：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text" value="<fmt:formatDate value="${requestScope.record.repairdate }" pattern="yyyy-MM-dd"/>" placeholder="" id="repairdate" name="repairdate">
						</div>
					</div>
					<div class="row clearfix">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>维修备注：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text" value="${requestScope.record.repairremarks }" placeholder="" id="repairremarks" name="repairremarks">
						</div>
					</div>
					
					
					
					<div class="row clearfix">
						<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
							<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/js/main.js"></script>
	<script type="text/javascript">
	//日期控件
	laydate.render({
		elem : '#birth' //指定元素
	});
		//验证表单
		$("#form").validate({
			rules : {
				receivedate : {
					required : true,//必填
				},
				rcremarks : {
					required : true,
				},
				returndate : {
					required : true,
				},
				rtremarks : {
					required : true,
				}
			},
			onkeyup : false,
			focusCleanup : true,
			submitHandler : function(form) {
				$(form).ajaxSubmit({
					type : form.method,
					url : form.action,
					success : function(data) {
						commonreuslt(data);
					}
				});
			}
		});
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
