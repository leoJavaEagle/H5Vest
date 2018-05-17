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
		<label for="project-code" class="col-sm-2 control-label">产品id:</label> 
		<div class="col-sm-10">
			<input type="text" class="form-control required" name="productId" id="productId">
		</div>
	</div>
	
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">产品类型:</label> 
		<div class="col-sm-10">
			<input type="text" class="form-control required" name="productType" id="productType">
		</div>
	</div>
	
	<div class="form-group">
		<label for="nameId" class="col-sm-2 control-label" >项目名称:</label> 
	    <div class="col-sm-10">
			<input type="text" class="form-control required" name="productName" id="productName"  placeholder="请输入名字">
	    </div>
	</div>
	
	<div class="form-group">
		<label for="project-code"  class="col-sm-2 control-label">产品图标:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control" name="productPictureUrl" id="productPictureUrl">
		</div>
	</div>
	
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">日利率:</label>
		<div class="col-sm-10">
			<input type="number" maxlength="6" class="form-control" name="dayRate" id="dayRate">
		</div>
	</div>
	
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">月利率:</label>
		<div class="col-sm-10">
			<input type="number" maxlength="6" class="form-control" name="monthRate" id="monthRate">
		</div>
	</div>
	
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">年利率:</label>
		<div class="col-sm-10">
			<input type="number" maxlength="6" class="form-control" name="yearRate" id="yearRate">
		</div>
	</div>
	
	<div class="form-group">
		<label for="project-code"  class="col-sm-2 control-label">借款期限:</label> 
		<div class="col-sm-10">
			<input type="text" class="form-control required" name="borrowPeriods" id="borrowPeriods">
		</div>
	</div>
	
	<div class="form-group">
         <label class="col-md-2 control-label"> 状态: </label>
         <div class="col-md-10" id="productStatus">
            <label class="radio-inline">
            	<input type="radio" name="status" value="0" id="start" required>启用
            </label>
            <label class="radio-inline">
            	<input type="radio" name="status" value="1" id="forbidden" required>禁用
            </label>
            <label class="radio-inline">
            	<input type="radio" name="status" value="2" id="waitSub" required>待提交
            </label>
          </div>
    </div>
    
    <div class="form-group">
		<label for="project-code"  class="col-sm-2 control-label">外部链接:</label> 
		<div class="col-sm-10">
			<input type="text" class="form-control" name="outUrl" id="outUrl">
		</div>
	</div>
	
	<div class="form-group">
		<label for="project-code"  class="col-sm-2 control-label">额度范围:</label> 
		<div class="col-sm-10">
			<input type="text" class="form-control required" name="amountLimit" id="amountLimit">
		</div>
	</div>
	
	<div class="form-group">
		<label for="project-code"  class="col-sm-2 control-label">放款时间:</label> 
		<div class="col-sm-10">
			<input type="text" class="form-control required" name="bizTime" id="bizTime">
		</div>
	</div>
	
	<div class="form-group">
         <label class="col-md-2 control-label"> 是否推荐: </label>
         <div class="col-md-10" id="productStatus">
            <label class="radio-inline">
            	<input type="radio" name="isDefault" value="1" id="yesDefault" required>是
            </label>
            <label class="radio-inline">
            	<input type="radio" name="isDefault" value="0" id="noDefault" required>否
            </label>
          </div>
    </div>
    
    <div class="form-group">
		<label for="project-code"  class="col-sm-2 control-label">图标路径:</label> 
		<div class="col-sm-10">
			<input type="text" class="form-control" name="logoTip" id="logoTip">
		</div>
	</div>
	
	<div class="form-group">
		<label for="project-code"  class="col-sm-2 control-label">产品提示:</label> 
		<div class="col-sm-10">
			<input type="text" class="form-control" name="productTip" id="productTip">
		</div>
	</div>
</form>
<c:url var="url" value="/ttms/product/product_edit.js"></c:url>
<script type="text/javascript" src="${url}"></script>