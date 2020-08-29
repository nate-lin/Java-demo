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
				<form action="${pageContext.request.contextPath}${requestScope.record != null ?  '/device/device/update.do' :'/device/device/insert.do'}" method="post" class="form form-horizontal" id="form">
					<!-- 隐藏表单 -->
					<c:if test="${requestScope.record != null }">
						<input type="hidden" name="id" value="${requestScope.record.id }">
					</c:if>
					<div class="row clearfix">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>部门：</label>
						<div class="formControls col-xs-8 col-sm-9">
						  <select id="ogid" name="ogid" class="input-text">
						     <option value="0">--请选择--</option>
						     <c:forEach items="${requestScope.rganizations}" var="rganization">
						     <option value="${rganization.id}" ${requestScope.record.ogid eq rganization.id?"selected":"" }>${rganization.name}</option>
						     </c:forEach>
						  </select>
						</div>
					</div>
					<div class="row clearfix">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>设备类型：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<select id="dtid" name="dtid" class="input-text">
							 <option value="0">--请选择--</option>
							  <c:forEach items="${requestScope.devicetypes}" var="devicetype">
						     <option value="${devicetype.id}" ${requestScope.record.dtid eq devicetype.id?"selected":"" }>${devicetype.name}--${devicetype.brand}</option>
						     </c:forEach>
							</select>
						</div>
					</div>
					
					<div class="row clearfix">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>净残值：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text" value="${requestScope.record.residual }" placeholder="" id="residual" name="residual">
						</div>
					</div>
					<div class="row clearfix">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>原值：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text" value="${requestScope.record.original }" placeholder="" id="original" name="original">
						</div>
					</div>
					<div class="row clearfix">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>状态：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<select id="status" name="status" class="input-text">
							<option value="1" ${requestScope.record.status eq 1 ?"selected":"" }>入库</option>
							<option value="2" ${requestScope.record.status eq 2 ?"selected":"" }>出库中</option>
							<option value="3" ${requestScope.record.status eq 3 ?"selected":"" }>出库</option>
							<option value="4" ${requestScope.record.status eq 4 ?"selected":"" }>领用</option>
							<option value="5" ${requestScope.record.status eq 5 ?"selected":"" }>报修</option>
							</select>
						</div>
					</div>
					<div class="row clearfix">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>生产日期：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text" value="<fmt:formatDate value="${requestScope.record.proddate}" pattern="yyyy-MM-dd"/>"  id="proddate" name="proddate">
						</div>
					</div>
					<div class="row clearfix">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>登记人：</label>
						<div class="formControls col-xs-8 col-sm-9">
							 <select id="creator" name="creator" class="input-text">
						     <option value="0">--请选择--</option>
						     <c:forEach items="${requestScope.users}" var="user">
						     <option value="${user.id}" ${requestScope.record.creator eq user.id?"selected":"" }>${user.name}</option>
						     </c:forEach>
						  </select>
						</div>
					</div>
					<div class="row clearfix">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>登记时间：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text" value="<fmt:formatDate value="${requestScope.record.createtime}" pattern="yyyy-MM-dd"/>"  id="createtime" name="createtime">
						</div>
					</div>
					<div class="row clearfix">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>购买人：</label>
						<div class="formControls col-xs-8 col-sm-9">
                           <select id="buyer" name="buyer" class="input-text">
						     <option value="0">--请选择--</option>
						     <c:forEach items="${requestScope.users}" var="user">
						     <option value="${user.id}" ${requestScope.record.buyer eq user.id?"selected":"" }>${user.name}</option>
						     </c:forEach>
						  </select>
						</div>
					</div>
					<div class="row clearfix">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>购买日期：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text" value="<fmt:formatDate value="${requestScope.record.bugdate}" pattern="yyyy-MM-dd"/>"  id="bugdate" name="bugdate">
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
				ogid : {
					required : true,//必填
				},
				dtid : {
					required : true,
				},
				residual : {
					required : true,
				},
				original : {
					required : true,
				},
				status : {
					required : true,
				},
				proddate : {
					required : true,
				},
				creator : {
					required : true,
				},
				createtime : {
					required : true,
				},
				buyer : {
					required : true,
				},
				bugdate : {
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
