<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/WEB-INF/inc/common.jsp"></jsp:include>
<title>设备领用/归还</title>
</head>
<body>
	<div class="wap-container">
		<article class="Hui-admin-content clearfix">
			<div class="panel">
				<form class="search-form" action="${pageContext.request.contextPath}/device/device/list.do">
					<div class="panel-body">
						<div class="row clearfix">
							<div class="col-xs-12 col-sm-6 col-md-4">
								<div class="row clearfix mb-10">
									<span class="col-xs-4 form-item-label">名称：</span> <span class="col-xs-4 form-item-control"> <input type="text" name="name"   value="${requestScope.page.prams.name }" placeholder="" class="input-text" />
									</span>
								</div>
							</div>
							<input type="hidden" name="method" value="list">
							<div class="col-xs-12 col-sm-6 col-md-4">
								<div class="row clearfix">
									<span class="col-xs-4 form-item-control">
										<button name="" id="search-submit" class="btn btn-success radius" type="submit">
											<i class="Hui-iconfont">&#xe665;</i> 搜索
										</button>
									</span>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="panel mt-20">
				<div class="panel-body">
					<div class="clearfix">
						<span class="f-l"> 
						<a href="javascript:;" onclick="batchdel('${pageContext.request.contextPath}/device/devicereceive/batchDelete.do')" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> 
						<a href="javascript:;" onclick="insert('领用','${pageContext.request.contextPath}/device/devicereceive/toInsert.do','800','500')" class="btn btn-primary radius"> <i class="Hui-iconfont">&#xe600;</i>领用
						</a>
						</span> <span class="f-r">共有数据：<strong>${requestScope.page.total }</strong> 条
						</span>
					</div>
					<div class="mt-20 clearfix">
						<table id="data-table-list" class="table table-border table-bordered table-bg table-hover table-sort">
							<thead>
								<tr class="text-c">
									<th width="25"><input type="checkbox" name="" value=""></th>
									<th>单据号</th>
									<th>设备流水号</th>
									<th>设备名称</th>
									<th>品牌</th>
									<th>型号</th>
									<th>领用人</th>
									<th>领取时间</th>
									<th>归还日期</th>
									<th>状态</th>
									<th>领用备注</th>
									<th>归还备注</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody class="getData-list" data-currPage='1'>
								<c:forEach items="${requestScope.page.records }" var="record">
									<tr class="text-c">
										<td><input type="checkbox" value="${record.id }" class="checkbox-box"></td>
										<td>${record.code }</td>
										<td>${record.dcode }</td>
										<td>${record.dname }</td>
										<td>${record.brand }</td>
										<td>${record.model }</td>
										<td>${record.rname }</td>
										<td>
										<fmt:formatDate value="${record.receivedate}" pattern="yyyy-MM-dd"/>
										</td>
										<td>
										<fmt:formatDate value="${record.returndate }" pattern="yyyy-MM-dd"/>
										</td>
										<td>
										<c:if test="${record.status eq 1}">领用</c:if>
										<c:if test="${record.status eq 2}">归还</c:if>
										</td>
										<td>${record.rcremarks }</td>
										<td>${record.rtremarks }</td>
										<td class="f-14 td-manage">
										<c:if test="${record.status eq 1}">
										<a title="归还" href="javascript:;" onclick="toBack('归还','${pageContext.request.contextPath}/device/devicereceive/toBack.do?&id=${record.id }','1','800','500')" class="btn btn-primary radius">
										<i class="Hui-iconfont">归还</i>
										</a>
										</c:if>
										<c:if test="${record.status eq 1}">
										<a title="编辑" href="javascript:;" onclick="update('编辑','${pageContext.request.contextPath}/device/devicereceive/toUpdateA.do?&id=${record.id }','1','800','500')" class="ml-5" style="text-decoration: none"><i class="Hui-iconfont">&#xe6df;</i></a>
										</c:if>
										<c:if test="${record.status eq 2}">
										<a title="编辑" href="javascript:;" onclick="update('编辑','${pageContext.request.contextPath}/device/devicereceive/toUpdateB.do?&id=${record.id }','1','800','500')" class="ml-5" style="text-decoration: none"><i class="Hui-iconfont">&#xe6df;</i></a>
										</c:if>
										
									    <c:if test="${record.status eq 1}">
										<a title="删除" href="javascript:;" onclick="del(this,'${pageContext.request.contextPath}/device/devicereceive/delete.do?&id=${record.id}')" class="ml-5" style="text-decoration: none"><i class="Hui-iconfont">&#xe6e2;</i></a>
									    </c:if>
									
										</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
					<div id="laypage" class="text-c"></div>
				</div>
			</div>
		</article>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/js/main.js"></script>
	<!--/请在上方写此页面业务相关的脚本-->
	<script type="text/javascript">
		//渲染分页
		laypage({
			cont : 'laypage',
			pages : ${requestScope.page.pages },  
			curr :  ${requestScope.page.pageNum },  
			jump : function(e, first) { //触发分页后的回调
				if (!first) { //一定要加此判断，否则初始时会无限刷新
					location.href = getFormUrl($(".search-form"))+"&pageNum="+e.curr;
				}
			}
		});   
		function insert(title, url, w, h) {
			//hui自己封装的方法
			//里面底层实现就是layer.open()
			layer_show(title, url, w, h);
		}
		function update(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
		
		function toBack(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
		
		
		
		function del(obj, url) {
			layer.confirm('确认要删除吗？', function(index) {
				$.ajax({
					type : 'POST',
					url : url,
					dataType : 'json',
					success : function(data) {
						commonreuslt(data);
					}
				});
			});
		} 
			
		function batchdel(url) {
			if ($(".checkbox-box:checked")) {
				if ($(".checkbox-box:checked").length > 0) {
					var pars = '';
					$(".checkbox-box:checked").each(function(i, v) {
						pars += '&ids=' + $(v).val();//pars = &ids=1&ids=2&ids=3
					});
					layer.confirm('确认要删除吗？', function(index) {
						$.ajax({
							type : 'POST',
							url : url,
							data : pars,
							success : function(data) {
								commonreuslt(data);
							}
						});
					});
				} else {
					layer.msg("请选择你要删除的内容", {
						icon : 5,
						time : 1000
					});
				}
			}

		}
	</script>
</body>
</html>