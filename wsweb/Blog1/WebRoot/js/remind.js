function changeSec(){
	$("myspan").innerText=parseInt($("myspan").innerText)-1;
}
var mytime = setInterval("changeSec()",1000);
function $(id){
	return document.getElementById(id);
}