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
		<label for="project-code" class="col-sm-2 control-label" >资讯标题:</label> 
	    <div class="col-sm-10">
			<input type="text" class="form-control required" name="title" id="title"  placeholder="请输入标题">
	    </div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">文章内容1段:</label> 
		<div class="col-sm-10">
		<!-- <input type="text" class="form-control required" name="code" id="codeId">-->
		<textarea rows="5" cols="5" class="form-control required" name="contentOne" id="contentOne" ></textarea>
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">文章内容2段:</label> 
		<div class="col-sm-10">
		<!-- <input type="text" class="form-control required" name="code" id="codeId">-->
		<textarea rows="5" cols="5" class="form-control required" name="contentTwo" id="contentTwo" ></textarea>
		</div>
	</div>
	<!--  <div class="form-group">
		<label for="project-code"  class="col-sm-2 control-label">创建时间:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control datepicker " name="code" id="beginDateId">
		</div>
	</div>-->
	<div class="form-group">
		<label for="project-code"  class="col-sm-2 control-label">阅读量:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required " name="readCount" id="readCount">
		</div>
	</div>
	<div class="form-group">
         <label class="col-md-2 control-label"> 状态: </label>
         <div class="col-md-10">
            <label class="radio-inline"><input  type="radio" name="status" checked value="0" > 显示</label>
            <label class="radio-inline"><input  type="radio" name="status" value="1"> 隐藏</label>
          </div>
    </div>
	<!--<div class="form-group">
		<label for="noteId" class="col-sm-2 control-label">备注:</label>
		<div class="col-sm-10">
		<textarea class="form-control" name="note" id="noteId"></textarea>
		</div> 
	</div>-->
</form>
<c:url var="url" value="/ttms/product/article_edit.js"></c:url>
<script type="text/javascript" src="${url}"></script>