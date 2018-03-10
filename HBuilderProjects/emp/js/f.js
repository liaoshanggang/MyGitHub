;_url = 'http://localhost:8080/paging';
;(function(){
	alert(2)
  var i=2017;

  var _btn=document.getElementById('btn');

  _btn.onclick=function(){
	  this.innerHTML='Hello！';
  }

})();

;window.onload=function(){
	
(function() {
	var _bd = document.getElementById('bd');
	_bd.onclick = function() {
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4) {
				if(xhr.status == 200) {
					var msg = document.getElementById('msg');
					msg.innerHTML = new Date().getTime();
					//msg.innerHTML = xhr.responseText;
				}
			}
		}
		xhr.open("GET", _url+"/ajax.jsp?"+new Date().getTime(),true);
		xhr.send(null);
	}

})();
(function(){
	var _sbmt=document.getElementById('sbmt');
	_sbmt.onclick=function(){
		var ee=window.event;
		ee.preventDefault();//阻止默认事件
	}
})();
}