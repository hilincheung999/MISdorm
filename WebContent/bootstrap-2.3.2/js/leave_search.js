!function(){
	laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
	laydate({elem: '#demo'});//绑定元素
}();

//日期范围限制
var start = {
    elem: '#start',
    format: 'YYYY-MM-DD',
    min: laydate.now(), //设定最小日期为当前日期
    max: '2099-06-16', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
    }
};

var end = {
    elem: '#end',
    format: 'YYYY-MM-DD',
    min: laydate.now(),
    max: '2099-06-16',
    istime: true,
    istoday: false,
    choose: function(datas){
        start.max = datas; //结束日选好后，充值开始日的最大日期
    }
};
laydate(start);
laydate(end);

$(document).ready(function(){
	$("#btnQuery").click(function(){
		getData();
	});
});
function getData() {
	
	var page=$('#page').val()-1;
	$.get("../leave_search", {keyword:$("#keyword").val(),page:page},function(m){
		$("table tr:gt(0)").remove();
		var html = "";
		$("#total").html(m.total);
		for (var i=0; i < m.rows.length; i++) {
			var r = m.rows[i];			
			html += "<tr><td>" + r.stunum + "</td>";
			html +="<td>" + r.stuname + "</td>";
			html +="<td>" + r.dormapt + "</td>";
			html +="<td>" + r.dormnum + "</td>";
			html +="<td>" + r.phone + "</td>";
			html +="<td>" + r.destination + "</td>";
			html +="<td>" + r.leavetime + "</td>";
			html +="<td>" + r.backtime + "</td></tr>";
		}
		$("table").append(html);
		$('#pageCount').html(m.total%5==0?m.total/5:parseInt(m.total/5+1));
		
	});
}
function previous(){
	if($('#page').val()>=2){
		$('#page').val(parseInt($('#page').val())-1);
		getData();
	}else{
	}		
}
function next(){
	if(parseInt($('#page').val())<parseInt($('#pageCount').html())){		
		$('#page').val(parseInt($('#page').val())+1);
		getData();
	}		
}
function first(){
	$('#page').val(1);
	getData();
}
function last(){
	$('#page').val($('#pageCount').html());
	getData();
}



$(document).ready(function(){
	$("#btn").click(function(){
		getData1();
	});
});

function getData1() {
	
	var page=$('#page').val()-1;
	$.get("../leave_search1", {start: $("#start").val(),end:$("#end").val(),page:page},function(m){
		$("table tr:gt(0)").remove();
		var html = "";
		$("#total").html(m.total);
		for (var i=0; i < m.rows.length; i++) {
			var r = m.rows[i];			
			html += "<tr><td>" + r.stunum + "</td>";
			html +="<td>" + r.stuname + "</td>";
			html +="<td>" + r.dormapt + "</td>";
			html +="<td>" + r.dormnum + "</td>";
			html +="<td>" + r.phone + "</td>";
			html +="<td>" + r.destination + "</td>";
			html +="<td>" + r.leavetime + "</td>";
			html +="<td>" + r.backtime + "</td></tr>";
		}
		$("table").append(html);
		$('#pageCount').html(m.total%5==0?m.total/5:parseInt(m.total/5+1));
		
	});
}
function previous(){
	if($('#page').val()>=2){
		$('#page').val(parseInt($('#page').val())-1);
		getData1();
	}else{
	}		
}
function next(){
	if(parseInt($('#page').val())<parseInt($('#pageCount').html())){		
		$('#page').val(parseInt($('#page').val())+1);
		getData1();
	}		
}
function first(){
	$('#page').val(1);
	getData1();
}
function last(){
	$('#page').val($('#pageCount').html());
	getData1();
}

//$(document).ready(function(){		
//	$("#btnQuery").click(function(){
//		$.get("../leave_search", { keyword: $("#keyword").val() }, function(m){
//			$("table tr:gt(0)").remove();
//			var html = "";
//			for (var i=0; i < m.rows.length; i++) {
//				var r = m.rows[i];
//				html += "<tr><td>" + r.stunum + "</td>";
//				html +="<td>" + r.stuname + "</td>";
//				html +="<td>" + r.dormapt + "</td>";
//				html +="<td>" + r.dormnum + "</td>";
//				html +="<td>" + r.phone + "</td>";
//				html +="<td>" + r.destination + "</td>";
//				html +="<td>" + r.leavetime + "</td>";
//				html +="<td>" + r.backtime + "</td></tr>";
//			}
//			$("table").append(html);
//		});
//		
//	});
//	
//});
//	$(document).ready(function(){		
//		$("#btn").click(function(){
//
//			$.get("../leave_search1", {start: $("#start").val(),end:$("#end").val()}, function(m){
//				$("table tr:gt(0)").remove();
//				var html = "";
//				for (var i=0; i < m.rows.length; i++) {
//					var r = m.rows[i];
//					html += "<tr><td>" + r.stunum + "</td>";
//					html +="<td>" + r.stuname + "</td>";
//					html +="<td>" + r.dormapt + "</td>";
//					html +="<td>" + r.dormnum + "</td>";
//					html +="<td>" + r.phone + "</td>";
//					html +="<td>" + r.destination + "</td>";
//					html +="<td>" + r.leavetime + "</td>";
//					html +="<td>" + r.backtime + "</td></tr>";
//		
//				}
//				$("table").append(html);
//			});
//		});
//		
//	});