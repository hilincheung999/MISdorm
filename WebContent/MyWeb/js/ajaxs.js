/**
 * 
 */

var req = null;
function test() {
	// 初始化
	var stuname = document.all.stuname.value;
	var phone = document.all.phone.value;
	var dormnum = document.all.dormnum.value;
	var email = document.all.email.value;
	req = new XMLHttpRequest();
	// 设置属性，当后台处理完成后，回来调用myDeal方法。
	req.onreadystatechange = myDeal;
	// 发出请求
	req.open("GET", "../ajaxs?dormnum=" + dormnum + "&phone=" + phone + "&stuname=" + stuname + "&email=" + email,
			"false");

	req.send(null);
}
function myDeal() {
	if (req.readyState == 4) {
		// 接收服务端返回的数据
		var ret = req.responseText;
		// 处理数据
		document.all("myDiv").innerHTML = ret;
	}
}