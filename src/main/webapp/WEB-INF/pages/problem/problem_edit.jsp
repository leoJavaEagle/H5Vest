<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
//初始化datepicker对象
$('.datepicker').datepicker({
    format: 'yyyy-mm-dd',
    autoclose: true//选中自动关闭
})
</script>
<form  class="form-horizontal" role="form" id="editFormId">
	<span id="errorInfo"></span>
	<div class="form-group hide">
		<label for="nameId" class="col-sm-2 control-label" >问题id:</label> 
	    <div class="col-sm-10">
			<input type="text" class="form-control" name="problemId" id="problemId" >
	    </div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">问题标题:</label> 
		<div class="col-sm-10">
			<input type="text" class="form-control required" name="title" id="title" placeholder="请输入标题名称">
		</div>
	</div>
	<div class="form-group">
         <label class="col-md-2 control-label"> 状态: </label>
         <div class="col-md-10">
            <label class="radio-inline"><input type="radio" name="status" value="0" > 启用</label>
            <label class="radio-inline"><input type="radio" name="status" value="1"> 禁用</label>
          </div>
    </div>
    <div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">问题内容:</label> 
		<div class="col-sm-10">
			<textarea class="form-control required" maxlength="500" name="content" id="content" placeholder="请输入内容，500字内" style="height:180px;resize:none;"></textarea>
		</div>
	</div>
</form>
<c:url var="url" value="/ttms/problem/problem_edit.js"></c:url>
<script type="text/javascript" src="${url}"></script>