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
			<input type="text" class="form-control required" name="productType" id="productType" placeholder="请输入产品类型  0、1、2、3、4、5">
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
		<input type="text" maxlength="255" class="form-control required" name="productPictureUrl" id="productPictureUrl" placeholder="请输入产品图标">
		</div>
	</div>
	
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">日利率:</label>
		<div class="col-sm-10">
			<input type="number" maxlength="6" class="form-control" name="dayRate" id="dayRate" placeholder="请输入利率，小数">
		</div>
	</div>
	
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">月利率:</label>
		<div class="col-sm-10">
			<input type="number" maxlength="6" class="form-control" name="monthRate" id="monthRate" placeholder="请输入利率，小数">
		</div>
	</div>
	
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">年利率:</label>
		<div class="col-sm-10">
			<input type="number" maxlength="6" class="form-control" name="yearRate" id="yearRate" placeholder="请输入利率，小数">
		</div>
	</div>
	
	<div class="form-group">
		<label for="project-code"  class="col-sm-2 control-label">借款期限:</label> 
		<div class="col-sm-10">
			<input type="text" class="form-control required" name="borrowPeriods" id="borrowPeriods" placeholder="请输入期限，如: 6—12月">
		</div>
	</div>
	
	<div class="form-group">
         <label class="col-md-2 control-label"> 状态: </label>
         <div class="col-md-10" id="productStatus">
            <label class="radio-inline">
            	<input type="radio" name="status" value="0" id="start">启用
            </label>
            <label class="radio-inline">
            	<input type="radio" name="status" value="1" id="forbidden">禁用
            </label>
            <label class="radio-inline">
            	<input type="radio" name="status" value="2" id="waitSub">待提交
            </label>
          </div>
    </div>
    
    <div class="form-group">
		<label for="project-code"  class="col-sm-2 control-label">外部链接:</label> 
		<div class="col-sm-10">
			<input type="text" class="form-control" name="outUrl" id="outUrl" placeholder="请输入第三方链接">
		</div>
	</div>
	
	<div class="form-group">
		<label for="project-code"  class="col-sm-2 control-label">额度范围:</label> 
		<div class="col-sm-10">
			<input type="text" class="form-control required" name="amountLimit" id="amountLimit" placeholder="请输入范围，如: 500~2W">
		</div>
	</div>
	
	<div class="form-group">
		<label for="project-code"  class="col-sm-2 control-label">放款时间:</label> 
		<div class="col-sm-10">
			<input type="text" class="form-control required" name="bizTime" id="bizTime" placeholder="请输入放款时间，如: 12小时">
		</div>
	</div>
	
	<div class="form-group">
         <label class="col-md-2 control-label"> 是否推荐: </label>
         <div class="col-md-10" id="productStatus">
            <label class="radio-inline">
            	<input type="radio" name="isDefault" value="1" id="yesDefault">是
            </label>
            <label class="radio-inline">
            	<input type="radio" name="isDefault" value="0" id="noDefault">否
            </label>
          </div>
    </div>
    
    <div class="form-group">
		<label for="project-code"  class="col-sm-2 control-label">图标路径:</label> 
		<div class="col-sm-10">
			<input type="text" class="form-control" name="logoTip" id="logoTip" placeholder="请输入小图标路径">
		</div>
	</div>
	
	<div class="form-group">
		<label for="project-code"  class="col-sm-2 control-label">产品提示:</label> 
		<div class="col-sm-10">
			<input type="text" class="form-control" name="productTip" id="productTip" placeholder="请输入产品提示">
		</div>
	</div>
</form>
<c:url var="url" value="/ttms/product/product_edit.js"></c:url>
<script type="text/javascript" src="${url}"></script>