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
	var url="/getArticle";
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
	console.log(data);
	$("#title").val(data.title);
	$("#thumburlShow").attr("src",data.image);
	$("#contentOne").val(data.contentOne);
	$("#contentTwo").val(data.contentTwo);
//	$("#createTime").val(data.createTime);
	$("#readCount").val(data.readCount);
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
	var addArticle="/addArticle";
	var updateArticle="/updateArticle";
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
	  title:$("#title").val(),
	  image:$("#image").val(),
	  contentOne:$("#contentOne").val(),
	  pictureOne:$("#pictureOne").val(),
	  contentTwo:$("#contentTwo").val(),
//	  createTime:$("#createTime").val(),
	  readCount:$("#readCount").val(),
	  status:$("input[type='radio']:checked").val()
//	  note:$("#noteId").val()
	}//JSON 对象
	return params;
}

/**
 * 用于进行图片上传，返回地址
 * @param obj
 * @returns
 */
function setImg(obj){
    var f=$(obj).val();
    if(f == null || f ==undefined || f == ''){
        return false;
    }
    if(!/\.(?:png|jpg|bmp|gif|PNG|JPG|BMP|GIF)$/.test(f))
    {
        alertLayel("类型必须是图片(.png|jpg|bmp|gif|PNG|JPG|BMP|GIF)");
        $(obj).val('');
        return false;
    }
    var data = new FormData();
    $.each($(obj)[0].files,function(i,file){
        data.append('file', file);
    });
    $.ajax({
        type: "POST",
        url: "/testuploadimg",
        data: data,
        cache: false,
        contentType: false,    //不可缺
        processData: false,    //不可缺
        dataType:"json",
        success: function(suc) {
        	console.log(suc);
            if(suc.code==0){
                    $("#image").val(suc.message);//将地址存储好
                    $("#thumburlShow").attr("src",suc.message);//显示图片                                                              
                }else{
                alert("上传失败");
                $("#url").val("");
                $(obj).val('');
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert("上传失败，请检查网络后重试");
            $("#url").val("");
            $(obj).val('');
        }
    });

    
}