  //将用户输入异步提交到服务器
 function ajaxSubmit(){
	//获取用户输入
	var title=document.getElementById("title").value;
	var author=document.getElementById("author").value;
	var content=$("#content").val();
	//创建XMLHttpRequest对象
	var xmlhttp;
	try{
		xmlhttp=new XMLHttpRequest();
	}catch(e){
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}

	//创建请求结果处理程序
	xmlhttp.onreadystatechange=function(){
		if (4==xmlhttp.readyState){
			if (200==xmlhttp.status){
				var date=xmlhttp.responseText;
				addToList(date);
			}else{
				alert("error");
			}
		}
	}
	//打开连接，true表示异步提交
	xmlhttp.open("post", "../note_add", true);
	//当方法为post时需要如下设置http头
	xmlhttp.setRequestHeader('Content-type','application/x-www-form-urlencoded');
	//发送数据
	xmlhttp.send("title="+title+"&author="+author+"&content="+content);
}
function addToList(date){
	//获取留言列表div容器
	var msg=document.getElementById("msgList");
	//创建dl标记及其子标记
	var dl=document.createElement("dl");
	var dt=document.createElement("dt");
	var dd=document.createElement("dd");
	var dd2=document.createElement("dd");
	//将结点插入到相应的位置
	msg.insertBefore(dl,msg.firstChild);
	dl.appendChild(dt);
	dl.appendChild(dd);
	dl.appendChild(dd2);
	//填充留言内容
	dt.innerHTML="<dl><dt>✲最新留言✲<br>标&nbsp;&nbsp;题："+$("#title").val();
	dd.innerHTML="</dt><dd>姓&nbsp;&nbsp;名："+$("#author").val()+" &nbsp;&nbsp;日&nbsp;&nbsp;期："+ date;
	dd2.innerHTML="</dd><dd>内&nbsp;&nbsp;容："+$("#content").val()+ "</dd></dl>";
	//清空用户输入框
	$("#title").val("");
	$("#author").val("");
	$("#content").val("");
}
