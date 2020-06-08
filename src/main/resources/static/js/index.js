var user=null;
var config=null;
var roles=null;
$(function(){
	initData();
//	alert(user);
//	alert(config);
//	alert(roles);
});
function initData(){
	$.ajax({
		url:"../loginSuccess",
		dataType:"json",
		type:"get",
		async:false,
		success:function(data){
			user=data[0];
			config=data[1];
			roles=data[2];
		}
	});
}












