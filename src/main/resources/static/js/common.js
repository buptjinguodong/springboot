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
Common.getUrlParam = function(name){
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
};

Common.alert = function(msg){
	alert(msg);
};
Common.msg = {};
Common.msg.popSuccessMessage = function(msg, succ) {

};
Common.msg.popWarnMessage = function(msg, succ) {

};
Common.msg.popErrorMessage = function(msg, succ) {

};
Common.msg.popConfirmMessage = function(msg, succ, fail) {

};

Common.getFirstChecked = function(allData){
    var selectInd = -1;
    for(var i=0; i<allData.length; i++){
        if(allData[i].check == true){
            selectInd = i;
            break;
        }
    }
    return selectInd;
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
			if (data.success == "false") {
				if (typeof options.failure == "function") {
                    options.failure(data);
				} else {
					Common.dealWithFailure(data);
				}
			} else {
                options.success(data);
			}
		}
	});
};

Common.dealWithFailure = function(data) {
	var thisVar = this;
	var flag = data.success;
	var errorMsg = data.errorMsg;

};