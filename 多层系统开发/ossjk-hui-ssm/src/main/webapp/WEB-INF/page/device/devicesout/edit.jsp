<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/taglib.jsp"%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
<title>审批</title>
<jsp:include page="/WEB-INF/inc/common.jsp"></jsp:include>
</head>
<body style="background-color: #fff">
	<div class="wap-container">
		<div class="panel">
			<div class="panel-body">
				<form action="${pageContext.request.contextPath}${requestScope.record != null ?  '/device/devicesout/update.do' :'/device/devicesout/insert.do'}" method="post" class="form form-horizontal" id="form">
					<!-- 隐藏表单 -->
					<c:if test="${requestScope.record != null }">
						<input type="hidden" name="id" value="${requestScope.record.id }">
					</c:if>
					<div class="row clearfix">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>设备信息：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<select class="input-text" id="did" name="did">
								<option value="0">--请选择--</option>
								<c:forEach items="${requestScope.devices }" var="device">
									<option value="${device.id}"${requestScope.record.did eq device.id?"selected":""}>${device.code}-${device.dname}-${device.brand}-${device.model}</option>
								</c:forEach>
							</select>						
						</div>
					</div>
					<div class="row clearfix">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>报废人：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<select class="input-text" id="outter" name="outter">
								<option value="0">--请选择--</option>
								<c:forEach items="${requestScope.users }" var="user">
									<option value="${user.id}" ${requestScope.record.did eq device.id?"selected":""}>${user.name}</option>
								</c:forEach>
							</select>	
						</div>
					</div>
					<div class="row clearfix">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>报废日期：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text" value="<fmt:formatDate value="${requestScope.record.outdate }" pattern="yyyy-MM-dd"/>" placeholder="" id="outdate" name="outdate">
						</div>
					</div>
					<div class="row clearfix">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>备注：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text" value="${requestScope.record.remarks }" placeholder="" id="remarks" name="remarks">
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
				outdate : {
					required : true,//必填
				},
				remarks : {
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
