/*
 * loader.js用于加载所有js和css
 */
function getRootPath() {
	//获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
	var curWwwPath = window.document.location.href;
	//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	//获取主机地址，如： http://localhost:8083
	var localhostPaht = curWwwPath.substring(0, pos);
	//获取带"/"的项目名，如：/uimcardprj
	var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	return (localhostPaht + projectName);
}
//jquery
document.write('<script src="'+getRootPath()+'/js/jquery-1.10.2.js"></script>');
//bootstrap
document.write('<script src="'+getRootPath()+'/js/bootstrap.min.js"></script>');
document.write('<link rel="stylesheet" href="'+getRootPath()+'/css/bootstrap.css"/>');
document.write('<link rel="stylesheet" href="'+getRootPath()+'/css/bootstrap-theme.css"/>');
//基于boostrap定制的表格插件
document.write('<script src="'+getRootPath()+'/js/bootstrap-table.js"></script>');
document.write('<link rel="stylesheet" href="'+getRootPath()+'/css/bootstrap-table.css"/>');
document.write('<script src="'+getRootPath()+'/js/bootstrap-table-zh-CN.js"></script>');
//消息提示框插件
document.write('<script src="'+getRootPath()+'/js/toastr.js"></script>');
document.write('<link rel="stylesheet" href="'+getRootPath()+'/css/toastr.css"/>');
//弹出框插件（alert、confirm、dialog）
document.write('<script src="'+getRootPath()+'/js/tip.js"></script>');
//rest风格插件（包含表单数据封装）
document.write('<script src="'+getRootPath()+'/js/restful.js"></script>');
//echart图表
document.write('<script src="'+getRootPath()+'/js/echarts.common.min.js"></script>');
//其他组件
document.write('<script src="'+getRootPath()+'/js/jquery.metisMenu.js"></script>');
document.write('<script src="'+getRootPath()+'/js/jquery.backstretch.min.js"></script>');
document.write('<link rel="stylesheet" href="'+getRootPath()+'/css/custom-styles.css"/>');
document.write('<link rel="stylesheet" href="'+getRootPath()+'/css/font-awesome.css"/>');


//3、初始化提示框
document.write("<script>toastr.options.positionClass = 'toast-top-center';</script>");