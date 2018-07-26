/**
 * 将form里面的内容序列化成json
 * 相同的checkbox用分号拼接起来
 * @param {dom} 指定的选择器
 * @param {obj} 需要拼接在后面的json对象
 * @method serializeJson
 * */
$.fn.serializeJson=function(otherString){
	var serializeObj={},
	array=this.serializeArray();
	$(array).each(function(){
		if(serializeObj[this.name]){
			serializeObj[this.name]+=';'+this.value;
		}else{
			serializeObj[this.name]=this.value;
		}
	});

	if(otherString!=undefined){
		var otherArray = otherString.split(';');
		$(otherArray).each(function(){
			var otherSplitArray = this.split(':');
			serializeObj[otherSplitArray[0]]=otherSplitArray[1];
		});
	}
	return serializeObj;
};

/**
 * 将josn对象赋值给form
 * @param {dom} 指定的选择器
 * @param {obj} 需要给form赋值的json对象
 * @method serializeJson
 * */
$.fn.setForm = function(jsonValue){
	var obj = this;
	$.each(jsonValue,function(name,ival){
		var $oinput = obj.find("input[name="+name+"]");
		if($oinput.attr("type")=="checkbox"){
			if(ival !== null){
				var checkboxObj = $("[name="+name+"]");
				var checkArray = ival.split(";");
				for(var i=0;i<checkboxObj.length;i++){
					for(var j=0;j<checkArray.length;j++){
						if(checkboxObj[i].value == checkArray[j]){
							checkboxObj[i].click();
						}
					}
				}
			}
		}
		else if($oinput.attr("type")=="radio"){
			$oinput.each(function(){
				var radioObj = $("[name="+name+"]");
				for(var i=0;i<radioObj.length;i++){
					if(radioObj[i].value == ival){
						radioObj[i].click();
					}
				}
			});
		}
		else if($oinput.attr("type")=="textarea"){
			obj.find("[name="+name+"]").html(ival);
		}
		else{
			obj.find("[name="+name+"]").val(ival);
		}
	});
};

/**
 * 发起rest请求
 * @param newurl 服务地址
 * @param model 参数
 * @method callback 回调函数
 * 注意：使用application/json方式传递参数一般要将json格式
 * 经过JSON.stringify(data)转化成字符串，否则将会报错
 * 此处另外注意：前端json参数可以在后端用对象接收，也可以用Map<String,Object>接收，
 * 但均需要添加注解@RequestBody。切记！！！
 * */
$.extend({
	//添加数据，兼容批量
	add : function(newurl, json, callback) {  
		$.ajax({  
			type: 'POST',  
			url: newurl,  
			data: JSON.stringify(json), // '{"name":"' + model.name + '"}',  
			dataType: 'text',
			processData: false,  
			contentType: 'application/json',  
			success: function(data){callback(isJSON(data)?$.parseJSON(data):data);},  
			error: function(req, status, ex) {toastr.error("操作异常！");},  
			timeout:60000  
		});  
	},

	//修改数据，兼容批量
	edit : function(newurl, json, callback) {  
		$.ajax({  
			type: 'PUT',  
			url: newurl,  
			data: JSON.stringify(json), // '{"name":"' + model.name + '"}',  
			dataType: 'text',  
			processData: false,  
			contentType: 'application/json',  
			success: function(data){callback(isJSON(data)?$.parseJSON(data):data);},  
			error: function(req, status, ex) {toastr.error("操作异常！");},  
			timeout:60000  
		});  
	},

	//根据id查询
	query : function(newurl, id, callback) {  
		$.ajax({  
			type: 'GET',  
			url: id + '/' + newurl,  
			contentType: 'application/json',  
			success: function(data){callback(isJSON(data)?$.parseJSON(data):data);},  
			error: function(req, status, ex) {toastr.error("操作异常！");},  
			timeout:60000  
		});  
	},
		
	//查询全部 或 采用restful路径参数
	queryAll : function(newurl, callback) {  

		$.ajax({  
			type: 'GET',  
			url: newurl,  
			contentType: 'application/json',  
			success: function(data){callback(isJSON(data)?$.parseJSON(data):data);},
			error: function(req, status, ex) {toastr.error("操作异常！");},  
			timeout:60000  
		});  
	},

	//根据id删除
	del : function(newurl, id, callback) {  
		$.ajax({  
			type: 'DELETE',  
			url:  id + '/' + newurl,  
			contentType: 'application/json',  
			success: function(data){callback(isJSON(data)?$.parseJSON(data):data);}, 
			error: function(req, status, ex) {toastr.error("操作异常！");},  
			timeout:60000  
		});  
	},
	
	//删除数据，兼容批量
	delAll : function(newurl, json, callback) {  
		$.ajax({  
			type: 'DELETE',  
			url:  newurl,  
			data: JSON.stringify(json), // '{"name":"' + model.name + '"}',  
			dataType: 'text',
			processData: false, 
			contentType: 'application/json',  
			success: function(data){callback(isJSON(data)?$.parseJSON(data):data);}, 
			error: function(req, status, ex) {toastr.error("操作异常！");},  
			timeout:60000  
		});  
	},

	loadTmpl : function(newurl, callback) {  
		$.ajax({  
			url: newurl,  
			success: function(data){callback(isJSON(data)?$.parseJSON(data):data);},  
			error: function(req, status, ex) {toastr.error("操作异常！");},  
			timeout:60000  
		});
	}

});

function isJSON(str) {
    if (typeof str == 'string') {
        try {
            var obj=JSON.parse(str);
            if(str.indexOf('{')>-1){
                return true;
            }else{
                return false;
            }

        } catch(e) {
            console.log(e);
            return false;
        }
    }
    return false;
}