var user=null;
var config=null;
var roles=null;
$(function(){
	initData();
	alert("1"+user);
	// alert("2"+config);
	// alert(roles);
});
function initData(){
	$.ajax({
		url:"/loginSuccess",
		dataType:"json",
		type:"get",
		async:false,
		success:function(data){
			user=data[0];
			//config=data[1];
			//roles=data[2];
		}
	});
	alert("11111"+user)

}












