//$(document).ready(function(){
//	
//	
//			$.get("../unshowwater", { }, function(m){
//				//回调函数    向服务器端发送参数
//				$("table tr:gt(0)").remove();//除了第一行的数据后，其他行都删除
//				
//				var tbl = "";
//				
//				for (var i = 0; i < m.rows.length; i++) {
//					var r = m.rows[i];
//					tbl += "<tr align='center' id='tr" + r.waterorder + "'><td>" + r.waterorder + "</td><td>" +r.stunum + "</td><td>"+ r.name +"</td><td>"  +r.dormnum+"</td><td>" +r.phone+"</td><td>" +
//					r.time+"</td><td ><a data='" + r.waterorder + "' class='btn btn-info'>确认订单</a></td></tr>";
//				}
//				//给a元素设置data属性
//				
//				$("table").append(tbl);
//				
//				$("table a").click(function(){
//					var id = $(this).attr("data");
//					$.get("../updatewater", { wo: id }, function(m1){    //传递参数
//						if (m1.S) { 
//							$("#tr" + id).remove();
//						}
//					});
//					
//				});
//		});
//		
//	});
$(document).ready(function(){	
		getData();
});	

function getData() {	
	var page=$('#page').val()-1;
	$.get("../unshowwater", {page:page},function(m){
		$("table tr:gt(0)").remove();
		var html = "";
		$("#total").html(m.total);
		for (var i=0; i < m.rows.length; i++) {
			var r = m.rows[i];			
			html += "<tr align='center' id='tr" + r.waterorder + "'><td>" + r.waterorder + "</td>";
			html += "<td>" + r.stunum + "</td>";
			html += "<td>" + r.name + "</td>";
			html += "<td>" + r.dormnum + "</td>";
			html += "<td>" + r.phone + "</td>";
			html += "<td>" + r.time + "</td><td ><a data='" + r.waterorder + "' class='btn btn-info'>确认订单</a></td></tr>";
		
		}
		$("table").append(html);
		$('#pageCount').html(m.total%5==0?m.total/5:parseInt(m.total/5+1));
		
		$("table a").click(function(){
		var id = $(this).attr("data");
     	$.get("../updatewater", { wo: id }, function(m1){    //传递参数
			if (m1.S) { 
				$("#tr" + id).remove();
			}
		});
		
	});
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