/*
 * report 页面下拉页面
 */
$(function(){
	$("#selectCityId").change(function(){
		var cityId = $("#selectCityId").val();
		var uri = '/report/cityId/'+cityId;
		window.location.href = uri;
	})
})