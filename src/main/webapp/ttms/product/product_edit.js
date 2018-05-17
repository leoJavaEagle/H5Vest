$(document).ready(function(){
	//模态框的.ok按钮上注册点击事件
   $("#modal-dialog").on("click",".ok",doSaveOrUpdate);
   
   $("#dayRate, #monthRate, #yearRate").on("blur", checkRateFormat);
   
   //在模态框隐藏后移除ok上注册的事件,防止数据多次提交.
   $("#modal-dialog").on("hidden.bs.modal",function() {
	   $("#modal-dialog").off("click",".ok");
	   //模态框隐藏时移除绑定的idKey
	   $("#modal-dialog").removeData("idKey");
   });
   //获取模态框上绑定的值
   var id=$("#modal-dialog").data("idKey");
   if(id)doFindObjectById(id);
});

/*根据id执行查询操作*/
function doFindObjectById(id){
	var url="findProductById";
	var params={"id":id};
	$.getJSON(url, params, function(result) {
		if(result.code == "000000"){
			doInitFormData(result.data);
		}else if(result.state==0) {
			alert("修改失败！");
		}
	});
}

/*修改初始化表单数据*/
function doInitFormData(data){
	$("#productId").val(data.id);
	$("#productType").val(data.productType);
	$("#productName").val(data.productName);
	$("#productPictureUrl").val(data.productPictureUrl);
	$("#dayRate").val(data.dayRate);
	$("#monthRate").val(data.monthRate);
	$("#yearRate").val(data.yearRate);
	$("#borrowPeriods").val(data.borrowPeriods);
	$("#editFormId input[name='status']").each(function(){
		if($(this).val()==data.status){
			$(this).prop("checked",true);
		}
	});
	$("#outUrl").val(data.outUrl);
	$("#amountLimit").val(data.amountLimit);
	$("#bizTime").val(data.bizTime);
	$("#editFormId input[name='isDefault']").each(function(){
		if($(this).val()==data.isDefault){
			$(this).prop("checked",true);
		}
	});
	$("#logoTip").val(data.logoTip);
	$("#productTip").val(data.productTip);
}

/*添加或修改数据*/
function doSaveOrUpdate(){
	//0.验证表单数据是否为空
	if(!$("#editFormId").valid())return;
	//1.获得表单数据
	var params = getEditFormData();
	if(!params) {
		return;
	}
	//2.异步提交表单数据
	var insertProduct="insertProduct";
	var updateProduct="updateProduct";
	//获取模态框上绑定的id值.
//	var id=$("#modal-dialog").data("idKey");
	//根据id判定是insert还是update
	var id = $("#productId").val();
	var url=id?updateProduct:insertProduct;
	//在修改时需要id的值,所以假如是修改需要动态添加id
//	if(id)params.id=id;
	$.ajax({
		 "url": url,
	     "data": params,
	     "type": "POST",
	     "contentType": "application/json;charset=utf-8",
	     "success": function(obj){
	 		if(obj.code == "000000"){
	 			//隐藏模态框
	 			$("#modal-dialog").modal("hide");
	 			//重新查询数据
	 			doGetObjects();
	 		}else{
	 			$("#errorInfo").text("修改失败！").css("color", "red");
	 		}
	     }
	});
//	$.post(url, params, function(result){
//		$("#errorInfo").text();
//		if(result.state == "000000"){
//			//隐藏模态框
//			$("#modal-dialog").modal("hide");
//			//重新查询数据
//			doGetObjects();
//		}else{
//			$("#errorInfo").text("修改失败！").css("color", "red");
//		}
//	});
}
/*获取表单数据*/
function getEditFormData(){
//	var params = $("#editFormId").serialize();
	$("#errorInfo").text("");
	var dayRate = $("#dayRate").val();
	var monthRate = $("#monthRate").val();
	var yearRate = $("#yearRate").val();
	
	var id = $("#productId").val();
	if(!id) {
		if(!dayRate) {
			if(!monthRate) {
				if(!yearRate) {
					$("#errorInfo").text("至少填写一项利率").css("color", "red");
					return;
				}
			}
		}
	}
	
	var status = $("input[name='status']:checked").val();
	if(!status) {
		$("#errorInfo").text("至少选择一项状态！").css("color", "red");
		return;
	}
	
	var isDefault = $("input[name='isDefault']:checked").val();
	if(!isDefault) {
		$("#errorInfo").text("至少选择一项是否推荐！").css("color", "red");
		return;
	}
	
	var params = JSON.stringify({
		id:id,
		productType:$("#productType").val(),
		productName:$("#productName").val(),
		productPictureUrl:$("#productPictureUrl").val(),
		dayRate:dayRate,
		monthRate:monthRate,
		yearRate:yearRate,
		borrowPeriods:$("#borrowPeriods").val(),
		status:status,
		outUrl:$("#outUrl").val(),
		amountLimit:$("#amountLimit").val(),
		bizTime:$("#bizTime").val(),
		isDefault:isDefault,
		logoTip:$("#logoTip").val(),
		productTip:$("#productTip").val()
	})
	return params;
}

function checkRateFormat(e) {
//	setTimeout(function() {  //进行延时处理，时间单位为千分之一秒
//        $('#auth_code').parent().find('.icon-clear').hide();
//    }, 100)
	var patrn = /^[0]+(.[0-9]{1,4})$/;
	let num = this.value;
//	alert(num);
	if(num) {
		if(!patrn.test(num)) {
			$("#errorInfo").text("利率格式不对，请重新输入").css("color", "red");
			this.style.color = "red";
		}else {
			$("#errorInfo").text("");
			this.style.color = "black";
		}
	}else {
		$("#errorInfo").text("");
		this.style.color = "black";
	}
}

//$('#auth_code').blur(function() {
//    setTimeout(function() {  //进行延时处理，时间单位为千分之一秒
//        $('#auth_code').parent().find('.icon-clear').hide();
//    }, 100)
//}).focus(function(){
//    if($(this).val() != ''){
//        $(this).parent().find('.icon-clear').css('display', 'table-cell');
//    }
//});