$(document).ready(function(){
   $("#modal-dialog")
   //模态框的.ok按钮上注册点击事件
   .on("click",".ok",doSaveOrUpdate);
   //在模态框隐藏后移除ok上注册的事件,防止数据多次提交.
   $("#modal-dialog")
   .on("hidden.bs.modal",function(){
	   console.log("==hidden.bs.modal==");
	   $("#modal-dialog").off("click",".ok");
	   //模态框隐藏时移除绑定的idKey(为什么?)
	   $("#modal-dialog").removeData("idKey");
	   //$(this).off("click",".ok");
	   //"hidden.bs.modal"表示模态框隐藏以后要执行的动作
   });
   //获取模态框上绑定的值
   var id=$("#modal-dialog").data("idKey");
   if(id)doFindObjectById(id);
});
/*根据id执行查询操作*/
function doFindObjectById(id){
	var url="/vest/getModel";
	var params={"id":id};
	$.getJSON(url,params,function(result){
		if(result.code=="000000"){
		  doInitFormData(result.data);//{"name":"","code":"",...}
		}else if(result.state=="000001"){
		  alert(result.message);
		}
	});
}
/*修改初始化表单数据*/
function doInitFormData(data){
	$("#source").val(data.source);
	$("#marketCode").val(data.marketCode);
	$("#marketName").val(data.marketName);
	$("#editFormId input[name='index']")
	.each(function(){
		if($(this).val()==data.index){
			$(this).prop("checked",true);
		}
	});
	$("#editFormId input[name='article']")
	.each(function(){
		if($(this).val()==data.article){
			$(this).prop("checked",true);
		}
	});
	$("#editFormId input[name='counter']")
	.each(function(){
		if($(this).val()==data.counter){
			$(this).prop("checked",true);
		}
	});
	$("#editFormId input[name='mine']")
	.each(function(){
		if($(this).val()==data.mine){
			$(this).prop("checked",true);
		}
	});
	$("#startTime").val(data.startTime);
	$("#endTime").val(data.endTime);
//	$("#noteId").html(data.note);
	$("#editFormId input[name='status']")
	.each(function(){
		if($(this).val()==data.status){
			$(this).prop("checked",true);
		}
	});
}
/*添加或修改数据*/
function doSaveOrUpdate(){
	//0.验证表单数据是否为空
	if(!$("#editFormId").valid())return;
	//1.获得表单数据
	var params=getEditFormData();
	console.log(params);
	//2.异步提交表单数据
	var addArticle="/vest/addModel";
	var updateArticle="/vest/updateModel";
	//获取模态框上绑定的id值.
	var id=$("#modal-dialog").data("idKey");
	//根据id判定是insert还是update
	var url=id?updateArticle:addArticle;
	//在修改时需要id的值,所以假如是修改需要动态添加id
	if(id)params.id=id;
	
	$.post(url,params,function(result){
		if(result.code=="000000"){
			//隐藏模态框
			$("#modal-dialog").modal("hide");
			//显示相关信息
			alert(result.message);
			//重新查询数据
			doGetObjects();
		}else{
			alert(result.message);
		}
	});
}
/*获取表单数据*/
function getEditFormData(){
	var params={
	  source:$("#source").val(),
	  marketCode:$("#marketCode").val(),
	  marketName:$("#marketName").val(),
	  index:$("input[type='radio'][name='index']:checked").val(),
	  article:$("input[type='radio'][ name='article']:checked").val(),
	  counter:$("input[type='radio'][ name='counter']:checked").val(),
	  mine:$("input[type='radio'][ name='mine']:checked").val(),
	  startTime:$("#startTime").val(),
	  endTime:$("#endTime").val(),
	  status:$("input[type='radio'][ name='status']:checked").val()
//	  note:$("#noteId").val()
	}//JSON 对象
	return params;
}