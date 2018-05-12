<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
//初始化datepicker对象
$('.datepicker').datepicker({
    format: 'yyyy/mm/dd',
    autoclose: true//选中自动关闭
})
</script>
<form  class="form-horizontal" role="form" id="editFormId">
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label" >来源:</label> 
	    <div class="col-sm-10">
			<input type="text" class="form-control required" name="source" id="source" >
	    </div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label" >渠道标识码:</label> 
	    <div class="col-sm-10">
			<input type="text" class="form-control required" name="marketCode" id="marketCode" >
	    </div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label" >渠道商名称:</label> 
	    <div class="col-sm-10">
			<input type="text" class="form-control required" name="marketName" id="marketName" >
	    </div>
	</div>
	<div class="form-group">
         <label class="col-md-2 control-label"> 首页模块: </label>
         <div class="col-md-10">
            <label class="radio-inline"><input  type="radio" name="index" checked value="0" > 显示</label>
            <label class="radio-inline"><input  type="radio" name="index" value="1"> 隐藏</label>
          </div>
    </div>
    <div class="form-group">
         <label class="col-md-2 control-label"> 资讯模块: </label>
         <div class="col-md-10">
            <label class="radio-inline"><input  type="radio" name="article" checked value="0" > 显示</label>
            <label class="radio-inline"><input  type="radio" name="article" value="1"> 隐藏</label>
          </div>
    </div>
    <div class="form-group">
         <label class="col-md-2 control-label"> 计算器模块: </label>
         <div class="col-md-10">
            <label class="radio-inline"><input  type="radio" name="counter" checked value="0" > 显示</label>
            <label class="radio-inline"><input  type="radio" name="counter" value="1"> 隐藏</label>
          </div>
    </div>
    <div class="form-group">
         <label class="col-md-2 control-label"> 我的模块: </label>
         <div class="col-md-10">
            <label class="radio-inline"><input  type="radio" name="mine" checked value="0" > 显示</label>
            <label class="radio-inline"><input  type="radio" name="mine" value="1"> 隐藏</label>
          </div>
    </div>
	<div class="form-group">
		<label for="project-code"  class="col-sm-2 control-label">开始时间:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control datepicker " name="startTime" id="startTime">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code"  class="col-sm-2 control-label">结束时间:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control datepicker " name="endTime" id="endTime">
		</div>
	</div>
	<div class="form-group">
         <label class="col-md-2 control-label"> 状态: </label>
         <div class="col-md-10">
            <label class="radio-inline"><input  type="radio" name="status" checked value="0" > 审核中</label>
            <label class="radio-inline"><input  type="radio" name="status" value="1"> 审核结束</label>
          </div>
    </div>
	<!--<div class="form-group">
		<label for="noteId" class="col-sm-2 control-label">备注:</label>
		<div class="col-sm-10">
		<textarea class="form-control" name="note" id="noteId"></textarea>
		</div> 
	</div>-->
</form>
<c:url var="url" value="/ttms/product/model_edit.js"></c:url>
<script type="text/javascript" src="${url}"></script>