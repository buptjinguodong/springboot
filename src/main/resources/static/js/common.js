Common = {};
/**
 * Common参数
 */
Common.options = {
	rootPath:"/demo"
};

Common.ROOT = Common.options.rootPath;

Common.log = function(str){
	alert(str);
};

Common.isObjUsable = function(obj){
	if(typeof(obj) == "undefined" || obj == "" || obj == null){
		return false;
	}else{
		return true;
	}
};
Common.post = function(options){
	var thisVar = this;
	// 参数异常
	if(!thisVar.isObjUsable(options)){
		thisVar.log("Common.post 参数错误");
		return null;
	}
	
	// 参数异常 - 外呼url必填
	if(!thisVar.isObjUsable(options.fw_url)){
		thisVar.log("Common.post 参数错误 - 外呼url必填");
		return null;
	}
	
	$.ajax({
		type:"post",
		url:thisVar.options.rootPath + options.fw_url,
		contentType:"application/json;charset=utf-8",
		data:options.data,
		success:function(data){
			options.success(data);
		}
	});
};