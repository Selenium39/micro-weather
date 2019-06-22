/**
 * report 页面下拉框实现
 * author: selenium
 */

$(function(){
 	$("#citySelect").change(function(){
		var cityName=$("#citySelect").val();
		var url="/weather/view/cityName/"+cityName;
		window.location.href=url;
	});
});