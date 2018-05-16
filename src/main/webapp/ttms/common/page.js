$(document).ready(function(){
	//在pageId对应的对象的相关元素上注册点击事件
	$("#pageId").on('click', '.pre,.next,.first,.last',jumpToPage);
});

//设置分页
function setPagination(pageInfo){
 //1.初始化总页数，显示前端
 $(".pageCount").html("总页数("+pageInfo.pageCount+")");
 //2.初始化当前页的页码
 $(".pageCurrent").html("当前页("+pageInfo.page+")");
 
 //3.总页
 $("#pageId").data("pageCount",pageInfo.pageCount);
 //4.当前页
 $("#pageId").data("pageCurrent",pageInfo.page);
}

//定义一个函数,通过此函数实现页面的跳转
function jumpToPage(){
	//获得点击对象上class属性对应的值,根据此值
	//判定具体点击的是哪个对象(例如上一页,下一页)
	var clazz=$(this).attr("class");
	//获得pageId对象上绑定的pageCurrent对应的值
	var pageCurrent=$('#pageId').data("pageCurrent");
	//获得pageId对象上绑定的pageCount对应的值
	var pageCount=$('#pageId').data("pageCount")
	//根据class属性的值判断点击的是否是上一页
	if(clazz=='pre'&&pageCurrent>1){
		pageCurrent--;
	}
	//判断点击的是否是下一页
	if(clazz=="next"&&pageCurrent<pageCount){
		pageCurrent++;
	}
	//判断点击的对象是否是首页
	if(clazz=="first"){
		pageCurrent=1;
	}
	//判定点击的对象是否是尾页
	if(clazz=="last"){
		pageCurrent=pageCount;
	}
	//重写绑定pageCurrent的值,
	$('#pageId').data("pageCurrent",pageCurrent);
	//重新执行查询操作(根据pageCurrent的值)
	doGetObjects();
}

$.extend($.validator.messages, {
    required: "这是必填字段",
    remote: "请修正此字段",
    email: "请输入有效的电子邮件地址",
    url: "请输入有效的网址",
    date: "请输入有效的日期",
    dateISO: "请输入有效的日期 (YYYY-MM-DD)",
    number: "请输入有效的数字",
    digits: "只能输入数字",
    creditcard: "请输入有效的信用卡号码",
    equalTo: "你的输入不相同",
    extension: "请输入有效的后缀",
    maxlength: $.validator.format("最多可以输入 {0} 个字符"),
    minlength: $.validator.format("最少要输入 {0} 个字符"),
    rangelength: $.validator.format("请输入长度在 {0} 到 {1} 之间的字符串"),
    range: $.validator.format("请输入范围在 {0} 到 {1} 之间的数值"),
    max: $.validator.format("请输入不大于 {0} 的数值"),
    min: $.validator.format("请输入不小于 {0} 的数值")
});







